package w1;

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
        attackNearbyUnits();
        Location myLocation = uc.getLocation();
        Location loc = uc.getLocation();

        int myAction = getAction();

        if(dest != null && (loc.distanceSquared(dest) > 9 ||
                uc.senseUnits(opponent).length > 0)) {
            moveTo(dest);
        }
        // If attack
        else if (myAction == 3)  {
            if(communication.enemyBaseCorners == -2) {
                dest = communication.enemyBaseLocation;
                moveTo(dest);
                uc.println("Barbarian set destination to enemy base " + dest.toString());
            }
            else if (communication.enemyBaseCorners == -1 &&
                    tryMove(myLocation.directionTo(communication.allyBaseLocation).opposite())) {
            }
            else if(loc.distanceSquared(communication.allyBaseLocation) < 4) tryRandomMove();
        }
        // Hold
        else if (myAction == 2) tryRandomMove();
        //Retreat
        else if (myAction == 0) {
            dest = communication.allyBaseLocation;
            moveTo(dest);
            uc.println("Barbarian set destination to ally base " + dest.toString());
        }
    }
}