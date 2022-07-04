package w1;

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

        Location myLocation = uc.getLocation();

        Direction movementDir = communication.getExplorerMovementDir();

        if (getCombatScore(opponent) >= getCombatScore(ally)) {
            dest = communication.allyBaseLocation;
            moveTo(dest);
            uc.println("Explorer set destination to " + dest.toString());
        }
        else if (movementDir == null ||
                (communication.foundBoundary(movementDir) && !communication.allBoundariesFound())) {
            communication.setExplorerMovementDir();
            movementDir = communication.getExplorerMovementDir();
            uc.println("Explorer set movement direction to " + movementDir.toString());
        }
        else if (communication.allBoundariesFound()) {
            if (dest == null) {
                if(communication.enemyBaseCorners == -2) {
                    dest = communication.enemyBaseLocation;
                    moveTo(dest);
                    uc.println("Explorer set destination to " + dest.toString());
                }
                else if (communication.enemyBaseCorners == -1 && tryMove(myLocation.directionTo(communication.allyBaseLocation).opposite())) {

                }
                else tryRandomMove();
            }
            else {
                moveTo(dest);
            }
        }

        attackNearbyEnemies();
        tryAdjMoves(movementDir);
    }
}