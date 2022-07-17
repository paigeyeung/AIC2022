package m3test;

import aic2022.user.*;

public class Barbarian extends AllyUnit {
    Location dest = null;
    int turnsSameDest = 0;

    Barbarian(UnitController uc) {
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

        if(attackAndMoveToClosestEnemyOrNeutralOrShrine())
            return;

        int myAction = getAction();
        uc.println("Barbarian action " + myAction);

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
                uc.println("Barbarian action ATTACK");
                uc.println("Barbarian set destination to enemy base " + dest.toString());
            }
            else {
                uc.println("Barbarian is exploring");
//                movementDir = getDirectionTo(communication.destOfBoundary(communication.getExplorerMovementDir()));

                ChestInfo closestChest = findClosestChest();
                if(closestChest != null) {
                    if(!openNearbyChests()) {
                        movementDir = getDirectionTo(closestChest.getLocation());
                    }
                    uc.println("Barbarian is going to treasure chests");
                }
                else if(communication.getShrineLocation() != null) {
                    dest = communication.getShrineLocation();
                    movementDir = getDirectionTo(dest);
                }
                else if (uc.getRound() % 400 < 250 && communication.getEntranceLocation() != null) {
                    movementDir = getDirectionTo(communication.getEntranceLocation());
                }
                else if(uc.getRound() % 400 < 200 && tryEnterDungeon() && !insideDungeon) {
                    insideDungeon = true;
                    uc.println("Barbarian entered a dungeon");
                }
                else if(uc.getRound() % 400 > 350 && tryEnterDungeon() && insideDungeon) {
                    insideDungeon = false;
                    uc.println("Barbarian exited a dungeon");
                }
                else {
                    movementDir = moveToRandDest();
                }
            }
//            else if(loc.distanceSquared(communication.allyBaseLocation) < 4) tryRandomMove();
        }
        // Hold
        else if (myAction == 2) {
            uc.println("Barbarian action HOLD");
            movementDir = moveToRandDest();
        }
        //Retreat
        else if (myAction == 0) {
            dest = communication.allyBaseLocation;
            movementDir = getDirectionTo(dest);
            uc.println("Barbarian set destination to ally base " + dest.toString());
        }

        ChestInfo closestChest = findClosestChest();
        if(closestChest != null) {
            movementDir = getDirectionTo(closestChest.getLocation());
            openNearbyChests();
        }

        tryAdjMoves(movementDir);
    }

    Direction getDirectionTo(Location destination) {
        Location myLocation = uc.getLocation();
        Direction movementDir = null;

        int f = Integer.MAX_VALUE;

        for(Direction dir : directions) {
            if(uc.canMove(dir) && dir != Direction.ZERO) {
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
            uc.println("Barbarian moving in " + movementDir + " -- " + tryAdjMoves(movementDir));
        }

        uc.println("Barbarian wants to move to destination " + destination + ", moves in dir " + movementDir + " to " + myLocation.add(movementDir));
        return movementDir;
    }

    Direction moveToRandDest() {
        Location myLocation = uc.getLocation();
//                    movementDir = getRandomMoveDirection(); //movementDir = getDirectionTo(communication.destOfBoundary(communication.getExplorerMovementDir()));
        if(dest == null || turnsSameDest > 100 || myLocation.distanceSquared(dest) < 10 ||
                uc.isOutOfMap(myLocation.add(myLocation.directionTo(dest)))) {
            dest = myLocation.add((int)(Math.random() * 80), (int)(Math.random() * 80));
            turnsSameDest = 0;
        }
        Direction movementDir = getDirectionTo(dest);
        turnsSameDest++;
        uc.println("Barbarian is moving randomly");
        return movementDir;
    }
}