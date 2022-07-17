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

        if(getCombatScore(Team.NEUTRAL) + getCombatScore(uc.getOpponent()) > getCombatScore(uc.getTeam())) {
            communication.callForHelp();
        }
        else if(getCombatScore(Team.NEUTRAL) + getCombatScore(uc.getOpponent()) < getCombatScore(uc.getTeam()) * 0.5) {
            communication.cancelCallForHelp();
        }

        while(true) {
            UnitType spawnUnitType;
            if(explorersSpawned < 1)
                spawnUnitType = UnitType.EXPLORER;
            else
                spawnUnitType = UnitType.BARBARIAN;

            Direction spawnDirection = getSpawnDirection(spawnUnitType);
            if(spawnDirection == null)
                break;

            uc.spawn(spawnUnitType, spawnDirection);

            if(spawnUnitType == UnitType.EXPLORER)
                explorersSpawned++;
            else if(spawnUnitType == UnitType.BARBARIAN)
                barbariansSpawned++;
            totalSpawned++;
            uc.println("Base spawning " + spawnUnitType + " towards " + spawnDirection);
        }
    }

    Direction getSpawnDirection(UnitType unitType) {
        for(Direction direction : directions) {
            if(uc.canSpawn(unitType, direction))
                return direction;
        }
        return null;
    }
}
