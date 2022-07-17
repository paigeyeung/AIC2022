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
        communication.initializeCallForHelp();
    }

    void run() {
        communication.downloadMapBoundariesAndCornerTracking();

        attackNearbyEnemyOrNeutralOrShrine();

        Location selfLocation = uc.getLocation();

        if(getCombatScore(neutral) + getCombatScore(opponent) > getCombatScore(ally)) {
            communication.callForHelp(selfLocation);
        }
        else if(getCombatScore(neutral) + getCombatScore(opponent) < getCombatScore(ally) * 0.5) {
            communication.cancelCallForHelp();
        }

        int round = uc.getRound();
        
        int explorersAlive = communication.getExplorerTally();
        int barbariansAlive = communication.getBarbarianTally();

        while(true) {
            UnitType spawnUnitType;
            if(explorersSpawned < 1)
                spawnUnitType = UnitType.EXPLORER;
            else if(explorersSpawned < 2 && explorersAlive < 1 && round > 500)
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
