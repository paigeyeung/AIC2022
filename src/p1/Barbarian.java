package p1;

import aic2022.user.*;

public class Barbarian extends AllyUnit {
    Location dest = null;

    Barbarian(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndEnemyBase();
    }

    void run() {
        communication.downloadMapBoundariesAndEnemyBase();
        attackNearbyEnemies();
        Location myLocation = uc.getLocation();

        Location loc = uc.getLocation();
        if(dest != null && (loc.distanceSquared(dest) > 9 ||
                uc.senseUnits(opponent).length > 0)) {
            moveTo(dest);
        }
        else if(loc.distanceSquared(communication.allyBaseLocation) < 4) {
            uc.println("Barbarian set destination to " + dest.toString());
            moveTo(dest);

            if (dest == null) {
                if(communication.enemyBaseCorner == -2) {
                    dest = communication.enemyBaseLocation;
                    uc.println("Explorer set destination to " + dest.toString());
                }
                else if (communication.enemyBaseCorner == -1 && tryMove(myLocation.directionTo(communication.allyBaseLocation).opposite())) {

                }
                else tryRandomMove();
            }
            tryRandomMove();
        }
        else {
//            int randomNumber = (int)(Math.random()*3);
//            if(randomNumber > 0) {
//                if(communication.enemyBaseCorner == -2) {
//                    dest = communication.enemyBaseLocation;
//                }
//                else if (communication.enemyBaseCorner == -1) {
//
//                }
//                else {
//                    dest = communication.allyBaseLocation;
//                }
//            }
        }
    }
}