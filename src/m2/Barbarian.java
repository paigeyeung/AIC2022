package m2;

import aic2022.user.*;

public class Barbarian extends AllyUnit {
    Location dest = null;

    Barbarian(UnitController uc) {
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

        if(attackAndMoveToClosestEnemyOrNeutral())
            return;

        int myAction = getAction();
        uc.println("Barbarian action " + myAction);

//        if(dest != null && (loc.distanceSquared(dest) > 9 ||
//                uc.senseUnits(opponent).length > 0)) {
//            moveTo(dest);
//        }

//        Direction movementDir = null;
//
//        // If attack
//        if (myAction == 3)  {
//            if(communication.cornerTrackingStatus == 2) {
//                dest = communication.enemyBaseLocation;
//                movementDir = getDirectionTo(dest);
//                uc.println("Barbarian action ATTACK");
//                uc.println("Barbarian set destination to enemy base " + dest.toString());
//            }
//            else {
//                uc.println("Barbarian is exploring");
//                movementDir = getDirectionTo(communication. destOfBoundary(communication.getExplorerMovementDir()));
//            }
////            else if(loc.distanceSquared(communication.allyBaseLocation) < 4) tryRandomMove();
//        }
//        // Hold
//        else if (myAction == 2) {
//            uc.println("Barbarian action HOLD");
//            movementDir = getRandomMoveDirection();
//        }
//        //Retreat
//        else if (myAction == 0) {
//            dest = communication.allyBaseLocation;
//            movementDir = getDirectionTo(dest);
//            uc.println("Barbarian set destination to ally base " + dest.toString());
//        }
//
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
}