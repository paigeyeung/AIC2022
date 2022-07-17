package m3;

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

    void run() {
        communication.downloadMapBoundariesAndCornerTracking();
        communication.lookForMapBoundaries();
        communication.lookForEnemyBase();

        attackNearbyEnemyOrNeutralOrShrine();

        Location selfLocation = uc.getLocation();

        if(communication.cornerTrackingStatus == 0
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
                dest = new Location(communication.mapWestBoundary + (int)(Math.random()
                        * (communication.mapEastBoundary - communication.mapWestBoundary)),
                        communication.mapSouthBoundary + (int)(Math.random()
                                * (communication.mapNorthBoundary - communication.mapSouthBoundary)));
        }

        uc.println("Explorer dest: " + dest);
        movedLastTurn = tryAdjMoves(getDirectionTo(dest));

//        Direction movementDir = communication.getExplorerMovementDir();
//
//        if (movementDir == null || (communication.foundBoundary(movementDir)
//                && !communication.allBoundariesFound())) {
//            communication.setExplorerMovementDir();
//            Location newDest = communication.destOfBoundary(communication.getExplorerMovementDir());
//            movementDir = getDirectionTo(newDest);
//            uc.println("Explorer set movement direction to " + movementDir);
//        }
//        else if (communication.allBoundariesFound()) {
//            if (dest == null) {
//                if(communication.cornerTrackingStatus == 2) {
//                    dest = communication.enemyBaseLocation;
//                    movementDir = getDirectionTo(dest);
//                    uc.println("Explorer set destination to " + dest.toString());
//                }
//                else if (communication.cornerTrackingStatus == 0) {
//                    dest = new Location((int)(Math.random()*30) + selfLocation.x, (int)(Math.random()*30) + selfLocation.y);
//                    movementDir = getDirectionTo(dest);
//                }
//                else {
//                    movementDir = getRandomMoveDirection();
//                }
//            }
//            else {
//                movementDir = getDirectionTo(dest);
//            }
//        }
//        tryAdjMoves(movementDir);
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