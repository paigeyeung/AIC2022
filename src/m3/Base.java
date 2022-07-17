package m3;

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
        communication.initializeMapBoundariesAndCornerTracking();
        communication.lookForMapBoundaries();
        communication.determineAllyBaseCornerFrom2Boundaries();
    }

    void run() {
        communication.downloadMapBoundariesAndCornerTracking();

        attackNearbyEnemyOrNeutralOrShrine();

        int explorersAlive = communication.getExplorerTally();
        int barbariansAlive = communication.getBarbarianTally();

        while(true) {
            UnitType spawnUnitType;
            if(explorersSpawned < 2 && explorersAlive < 1)
                spawnUnitType = UnitType.EXPLORER;
            else
                spawnUnitType = UnitType.BARBARIAN;

            Direction spawnDirection = getSpawnDirection(spawnUnitType);
            if(spawnDirection == null)
                break;

            uc.spawn(spawnUnitType, spawnDirection);

            if(spawnUnitType == UnitType.EXPLORER) {
                explorersSpawned++;
                explorersAlive++;
            }
            else if(spawnUnitType == UnitType.BARBARIAN) {
                barbariansSpawned++;
                barbariansAlive++;
            }
            uc.println("Base spawning " + spawnUnitType + " towards " + spawnDirection);
        }

        communication.resetTallies();
    }

    Direction getSpawnDirection(UnitType unitType) {
        for(Direction direction : directions) {
            if(uc.canSpawn(unitType, direction))
                return direction;
        }
        return null;
    }
}
