package wtest_evolution_pvp_1;

import aic2022.user.*;

public class Base extends AllyUnit {
    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.uploadAllyBase(uc.getLocation());
        communication.initializeBoundaries();
        communication.lookForMapBoundaries();
    }

    void run() {
        if(uc.canSpawn(UnitType.BARBARIAN, Direction.SOUTH))
            uc.spawn(UnitType.EXPLORER, Direction.SOUTH);

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(true, false);
        if(nearestEnemyOrNeutral != null) {
            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
            if(damage != 0)
                communication.addScore(damage);
        }
    }
}
