package wtest1;

import aic2022.user.*;

public class Troop extends AllyUnit {
    Location formationLocation = null;
    Location battleLocation = null;
    Location centerLocation = null;

    Troop(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndEnemyBase();

        selfSpawnIndex = communication.getSelfSpawnIndex();
        formationNumber = communication.getFormationNumber();
        if(formationNumber == 1)
            formation = formation1;
        else
            formation = formation2;
        formationLocation = communication.getSelfFormationLocation(formation[selfSpawnIndex]);
        battleLocation = communication.getBattleLocation(formationLocation);
        centerLocation = communication.getCenterLocation(formationLocation);
    }

    void run() {
        communication.downloadMapBoundariesAndEnemyBase();

        communication.reportAlive();

        int action = communication.getAction();
        uc.println("action " + action);
        if(action == 0) {
            moveTo(formationLocation, false, false);
        }
        else if(action == 1) {
            moveTo(battleLocation, false, true);
        }
        else {
            if(!attackAndMoveToClosestEnemyOrNeutral()) {
                moveTo(centerLocation, true, false);
            }
        }
    }
}