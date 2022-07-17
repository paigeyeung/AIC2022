package m3test;

import aic2022.user.*;

public class Base extends AllyUnit {
    int explorersSpawned = 0;
    int barbariansSpawned = 0;
    int rangersSpawned = 0;
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
        
        int explorersAlive = communication.getExplorerTally();
        int barbariansAlive = communication.getBarbarianTally();
        int rangersAlive = communication.getRangerTally();

        while(true) {
            UnitType spawnUnitType;
            if(explorersSpawned < 5 && explorersAlive < 2)
                spawnUnitType = UnitType.EXPLORER;
            else if (barbariansAlive < 0.5 * rangersAlive)
                spawnUnitType = UnitType.BARBARIAN;
            else
                spawnUnitType = UnitType.RANGER;

            Direction spawnDirection = getSpawnDirection(spawnUnitType);
            if(spawnDirection == null)
                break;

            uc.spawn(spawnUnitType, spawnDirection);

            if(spawnUnitType == UnitType.EXPLORER) {
                explorersSpawned++;
                explorersAlive++;
            }
            else if(spawnUnitType == UnitType.RANGER) {
                rangersSpawned++;
                rangersAlive++;
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
