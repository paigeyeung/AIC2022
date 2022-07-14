package m1;

import aic2022.user.*;

public class Base extends AllyUnit {
    int explorersSpawned = 0;
    int barbariansSpawned = 0;
    int totalSpawned = 0;

    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.uploadAllyBase(uc.getLocation());
        communication.initializeMapBoundariesAndEnemyBaseCorners();
        communication.lookForMapBoundaries();
    }

    void run() {
        communication.downloadMapBoundariesAndEnemyBase();

        attackNearbyEnemyOrNeutral();

        UnitType spawnUnitType;
        if(explorersSpawned < 2)
            spawnUnitType = UnitType.EXPLORER;
        else
            spawnUnitType = UnitType.BARBARIAN;

        if(spawnUnitType == null)
            return;

        Direction spawnDirection = getSpawnDirection(spawnUnitType);
        if(spawnDirection == null)
            return;

        uc.spawn(spawnUnitType, spawnDirection);
        if(spawnUnitType == UnitType.EXPLORER)
            explorersSpawned++;
        else if(spawnUnitType == UnitType.BARBARIAN)
            barbariansSpawned++;
        totalSpawned++;
        uc.println("BASE: Spawning " + spawnUnitType + " towards " + spawnDirection);
    }

    Direction getSpawnDirection(UnitType unitType) {
        for(Direction direction : directions) {
            if(uc.canSpawn(unitType, direction))
                return direction;
        }
        return null;
    }
}
