package m3mage;

import aic2022.user.*;

public class Base extends AllyUnit {
    int explorersSpawned = 0;
    int barbariansSpawned = 0;
    int magesSpawned = 0;
    int rangersSpawned = 0;
    int knightsSpawned = 0;
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

    void runSecondTurn() {
        communication.determineAssemblyLocation();
    }

    void run() {
        communication.downloadMapBoundariesAndCornerTracking();

        attackNearbyEnemyOrNeutralOrShrine();

        Location selfLocation = uc.getLocation();

        if(getCombatScore(neutral) + getCombatScore(opponent) > getCombatScore(ally)) {
            communication.setGroupAttack(selfLocation, 4, false);
        }

        int round = uc.getRound();
        
        int explorersAlive = communication.getExplorerTally();
        int barbariansAlive = communication.getBarbarianTally();
        int magesAlive = communication.getMageTally();
        int rangersAlive = communication.getRangerTally();
        int knightsAlive = communication.getKnightTally();

        while(true) {
            UnitType spawnUnitType;
            if(explorersSpawned < 1)
                spawnUnitType = UnitType.EXPLORER;
            else if(explorersSpawned < 2 && explorersAlive < 1 && round > 500)
                spawnUnitType = UnitType.EXPLORER;
            else if(magesAlive == 0 && barbariansAlive >= 5)
                spawnUnitType = UnitType.MAGE;
//            else if(knightsAlive < 0.3 * rangersAlive)
//                spawnUnitType = UnitType.KNIGHT;
//            else
//                spawnUnitType = UnitType.RANGER;
            else spawnUnitType = UnitType.BARBARIAN;

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
            else if(spawnUnitType == UnitType.MAGE) {
                magesSpawned++;
                magesAlive++;
            }
            else if(spawnUnitType == UnitType.RANGER) {
                rangersSpawned++;
                rangersAlive++;
            }
            else if(spawnUnitType == UnitType.KNIGHT) {
                knightsSpawned++;
                knightsAlive++;
            }
            uc.println("Base spawning " + spawnUnitType + " towards " + spawnDirection);
        }

        Location currentGroupAttackLocation = communication.getGroupAttackLocation();
        Location lastGroupCenterLocation = communication.getLastGroupCenterLocation();
        if(currentGroupAttackLocation == null || lastGroupCenterLocation == null
                || Math.random() * 10 <= 1) {
            communication.setGroupAttack(communication.getRandomDestination(), 1, false);
        }
        else if(currentGroupAttackLocation.distanceSquared(lastGroupCenterLocation) <= 20
                || Math.random() * 20 <= 1) {
            communication.setGroupAttack(communication.getRandomDestination(), 1, true);
        }
        else if(communication.cornerTrackingStatus == 2) {
            communication.setGroupAttack(communication.enemyBaseLocation, 2, false);
        }

        communication.resetTallies();
        communication.resetGroupAndAssembly();
    }

    Direction getSpawnDirection(UnitType unitType) {
        for(Direction direction : directions) {
            if(uc.canSpawn(unitType, direction))
                return direction;
        }
        return null;
    }
}
