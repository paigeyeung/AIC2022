package wtest_evolution_pvp_1;

import aic2022.user.*;

public class Base extends AllyUnit {
    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        Location selfLocation = uc.getLocation();

        communication.uploadAllyBase(selfLocation);
        communication.initializeBoundaries();
        communication.lookForMapBoundaries();

        if(communication.mapWestBoundary == selfLocation.x - 1)
            communication.uploadEnemyBaseLocation(new Location(selfLocation.x - 29, selfLocation.y));
        else
            communication.uploadEnemyBaseLocation(new Location(selfLocation.x + 29, selfLocation.y));
    }

    void run() {
        trySpawn(UnitType.BARBARIAN);

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(true, true);
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
