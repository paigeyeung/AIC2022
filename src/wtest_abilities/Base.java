package wtest_abilities;

import aic2022.user.*;

public class Base extends AllyUnit {
    int numSpawned = 0;

    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.uploadAllyBase(uc.getLocation());
        communication.initializeMapBoundariesAndCornerTracking();
        communication.lookForMapBoundaries();
        communication.determineAllyBaseCornerFrom2Boundaries();
        communication.initializeCallForHelp();
    }

    void run() {
        communication.uploadAllyBase(uc.getLocation());
        communication.downloadMapBoundariesAndCornerTracking();

        UnitType spawn = null;
        if(numSpawned == 0)
            spawn = UnitType.EXPLORER;
        else if(numSpawned == 1)
            spawn = UnitType.MAGE;

        if(spawn != null) {
            Direction dir = getRandomDirection();
            uc.println("spawn: " + spawn + ", dir: " + dir);
            if (uc.canSpawn(spawn, dir)) {
                uc.spawn(spawn, dir);
                numSpawned++;
            }
        }

        attackNearbyEnemyOrNeutral();
    }
}
