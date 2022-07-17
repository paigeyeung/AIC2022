package m3test;

import aic2022.user.*;

public class Ranger extends AllyUnit {
    Location dest = null;

    Ranger(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndCornerTracking();
    }

    void run() {
        communication.addToTally();
        communication.downloadMapBoundariesAndCornerTracking();
        communication.lookForMapBoundaries();
        communication.lookForEnemyBase();

        if(attackNearbyEnemyOrNeutralOrShrine() > 0)
            return;

        int myAction = getAction();
        uc.println("Ranger action " + myAction);

//        if(dest != null && (loc.distanceSquared(dest) > 9 ||
//                uc.senseUnits(opponent).length > 0)) {
//            moveTo(dest);
//        }

//        Direction movementDir = null;
//

        Direction movementDir = null;

        // If attack
        if (myAction == 3)  {
            if(communication.cornerTrackingStatus == 2) {
                dest = communication.enemyBaseLocation;

                movementDir = getDirectionTo(dest);
                uc.println("Ranger action ATTACK");
//                uc.println("Ranger set destination to enemy base " + dest.toString());
            }
            else {
                uc.println("Ranger is exploring");
//                movementDir = getDirectionTo(communication.destOfBoundary(communication.getExplorerMovementDir()));

                ChestInfo closestChest = findClosestChest();
                if(closestChest != null) {
                    if(!openNearbyChests()) {
                        movementDir = getDirectionTo(closestChest.getLocation());
                        uc.println("Ranger is going to treasure chests");
                    }
                }
                else if (uc.getRound() % 400 < 250 && communication.getEntranceLocation() != null) {
                    movementDir = getDirectionTo(communication.getEntranceLocation());

                }
                else if(uc.getRound() % 400 < 200 && tryEnterDungeon() && !insideDungeon) {
                    insideDungeon = true;
                    uc.println("Ranger entered a dungeon");
                }
                else if(uc.getRound() % 400 > 350 && tryEnterDungeon() && insideDungeon) {
                    insideDungeon = false;
                    uc.println("Ranger exited a dungeon");
                }
                else {
                    movementDir = getRandomMoveDirection(); //movementDir = getDirectionTo(communication.destOfBoundary(communication.getExplorerMovementDir()));
                    uc.println("Ranger is moving randomly");
                }
            }
//            else if(loc.distanceSquared(communication.allyBaseLocation) < 4) tryRandomMove();
        }
        // Hold
        else if (myAction == 2) {
            uc.println("Ranger action HOLD");
            movementDir = getRandomMoveDirection();
        }
        //Retreat
        else if (myAction == 0) {
            dest = communication.allyBaseLocation;
            movementDir = getDirectionTo(dest);
            uc.println("Ranger set destination to ally base " + dest.toString());
        }

        tryAdjMoves(movementDir);
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
                uc.println("Barbarian: Cost of moving in direction " + dir + " is " + newF);

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
            uc.println("Ranger moving in " + movementDir + " -- " + tryAdjMoves(movementDir));
        }

        uc.println("Ranger wants to move to destination " + destination + ", moves in dir " + movementDir + " to " + myLocation.add(movementDir));
        return movementDir;
    }
}