package wtest_evolution;

import aic2022.user.*;

public class Explorer extends AllyUnit {
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
    }
}