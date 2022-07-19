package m3mage;

import aic2022.user.*;

public class Explorer extends AllyUnit {
    Location dest = null;
    boolean movedLastTurn = false;

    Explorer(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndCornerTracking();
    }

    void runSecondTurn() {}

    void run() {
        communication.addSelfToTally();
        communication.downloadMapBoundariesAndCornerTracking();
        communication.lookForMapBoundaries();
        communication.lookForEnemyBase();

        if(attackNearbyEnemyOrNeutralOrShrine() == 2)
            return;

        Location selfLocation = uc.getLocation();

        ChestInfo closestChest = findClosestChest();
        if(closestChest != null) {
            dest = closestChest.getLocation();
            openNearbyChests();
        }
        else if(communication.cornerTrackingStatus == 0
                || (communication.cornerTrackingStatus == 1
                && !communication.allBoundariesFound())) {
            uc.println("Explorer looking for boundaries");
            Direction possibleEnemyBaseCorner = communication.getPossibleEnemyBaseCorner();
            dest = selfLocation.add(possibleEnemyBaseCorner);
        }
        else if(communication.cornerTrackingStatus == 1) {
            uc.println("Explorer looking for enemy base");
            Direction possibleEnemyBaseCorner = communication.getPossibleEnemyBaseCorner();
            Location possibleEnemyBaseLocation = communication.getEnemyBaseLocationIfEnemyBaseIsInCorner(possibleEnemyBaseCorner);
            dest = possibleEnemyBaseLocation;
        }
        else if(communication.cornerTrackingStatus == 2) {
            uc.println("Explorer already found enemy base");
            if(dest == null || selfLocation.distanceSquared(dest) < 2
                    || (!movedLastTurn && Math.random() * 10 <= 1))
                dest = communication.getRandomDestination();
        }

        uc.println("Explorer dest: " + dest);
        movedLastTurn = tryAdjMoves(getDirectionTo(dest));
    }

    Direction getDirectionTo(Location destination) {
        Location myLocation = uc.getLocation();

        Direction movementDir = null;

        int f = Integer.MAX_VALUE;

        for(Direction dir : directions) {
            if(uc.canMove(dir)) {
                Location adj = myLocation.add(dir);
                int newDist = adj.distanceSquared(destination);
                int newF = (int)Math.sqrt(newDist) * 4 + getVisited(adj);
                uc.println("Explorer: Cost of moving in direction " + dir + " is " + newF);

                if(newF < f) {
                    f = newF;
                    movementDir = dir;
                }
                else if(newF == f){
                    if((int)(Math.random()*2)==0) {
                        f = newF;
                        movementDir = dir;
                    }
                }
            }
        }

        if (movementDir != null) {
            uc.println("Explorer moving in " + movementDir + " -- " + tryAdjMoves(movementDir));
        }
        return movementDir;
    }
}