package m1;

import aic2022.user.*;

public class Explorer extends AllyUnit {
    Location dest = null;

    //    Direction movementDir = getRandomDirection();
    Explorer(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndEnemyBase();
    }

    void run() {
        communication.downloadMapBoundariesAndEnemyBase();
        communication.lookForMapBoundaries();

        attackNearbyEnemyOrNeutral();

        Location selfLocation = uc.getLocation();

        Direction movementDir = communication.getExplorerMovementDir();

//        if (getCombatScore(opponent) >= getCombatScore(ally)) {
//            dest = communication.allyBaseLocation;
//            moveTo(dest);
//            uc.println("Explorer set destination to " + dest.toString());
//        }
        if (movementDir == null ||
                (communication.foundBoundary(movementDir) && !communication.allBoundariesFound())) {
            communication.setExplorerMovementDir();
            Location newDest = communication.destOfBoundary(communication.getExplorerMovementDir());
            movementDir = getDirectionTo(newDest);
            uc.println("Explorer set movement direction to " + movementDir.toString());
        }
        else if (communication.allBoundariesFound()) {
            if (dest == null) {
                if(communication.enemyBaseCorners == -2) {
                    dest = communication.enemyBaseLocation;
                    movementDir = getDirectionTo(dest);
                    uc.println("Explorer set destination to " + dest.toString());
                }
                else if (communication.enemyBaseCorners == -1) {
                    dest = new Location((int)(Math.random()*30) + selfLocation.x, (int)(Math.random()*30) + selfLocation.y);
                    movementDir = getDirectionTo(dest);
                }
                else {
                    movementDir = getRandomMoveDirection();
                }
            }
            else {
                movementDir = getDirectionTo(dest);
            }
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
                int newDist = adj.distanceSquared(dest);
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