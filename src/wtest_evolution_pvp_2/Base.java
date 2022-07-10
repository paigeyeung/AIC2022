package wtest_evolution_pvp_2;

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
        trySpawn(UnitType.BARBARIAN);

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(true, false);
        if(nearestEnemyOrNeutral != null) {
            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
            if(damage != 0)
                communication.addScore(damage);
        }
    }

    boolean trySpawn(UnitType unitType) {
        for(Direction direction : directions) {
            if(uc.canSpawn(unitType, direction)) {
                uc.spawn(unitType, direction);
                return true;
            }
        }
        return false;
    }
}
