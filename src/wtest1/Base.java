package wtest1;

import aic2022.user.*;

public class Base extends AllyUnit {
    int lastNumUnitsAlive = 0;
    int noUnitsAliveRounds = 0;

    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.uploadAllyBase(uc.getLocation());
        communication.initializeMapBoundariesAndEnemyBaseCorners();
        communication.lookForMapBoundaries();
        communication.guessEnemyBaseCorners();

        formationNumber = communication.setFormation();
        if(formationNumber == 1)
            formation = formation1;
        else
            formation = formation2;
        communication.setAction(0);
    }

    void run() {
        communication.downloadMapBoundariesAndEnemyBase();

        if(200 + uc.getRound() == formationGold + 50)
            communication.setAction(1);
        else if(200 + uc.getRound() == formationGold + 100) {
            communication.setAction(2);
            lastNumUnitsAlive = communication.resetNumUnitsAlive();
        }
        else if(200 + uc.getRound() > formationGold + 100) {
            int numUnitsAlive = communication.resetNumUnitsAlive();
            if(numUnitsAlive == 0) {
                noUnitsAliveRounds++;
                if(noUnitsAliveRounds >= 2) {
                    uc.killSelf();
                }
            }
            lastNumUnitsAlive = numUnitsAlive;
        }

        int spawnIndex = communication.getSpawnIndex();
        if(spawnIndex >= formation.length)
            return;

        UnitType spawn = formation[spawnIndex].unitType;
        Direction dir = getRandomDirection();
        uc.println("spawn: " + spawn + ", dir: " + dir);
        if (uc.canSpawn(spawn, dir)) {
            uc.spawn(spawn, dir);
            communication.increaseSpawnIndex();
        }
    }
}
