package wtest1;

import aic2022.user.*;

public class Base extends AllyUnit {
    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.uploadAllyBase(uc.getLocation());
        communication.initializeMapBoundariesAndEnemyBaseCorners();
        communication.lookForMapBoundaries();
        communication.guessEnemyBaseCorners();

        communication.setFormation();
        communication.setAction(0);
    }

    void run() {
        communication.downloadMapBoundariesAndEnemyBase();

        if(uc.getRound() == 100)
            communication.setAction(1);
        else if(uc.getRound() == 150)
            communication.setAction(2);

        int spawnIndex = communication.getSpawnIndex();
        if(spawnIndex >= formation.length)
            return;

        UnitType spawn = formation[spawnIndex].unitType;
        Direction dir = getRandomDirection();
        if (uc.canSpawn(spawn, dir)) {
            uc.spawn(spawn, dir);
            communication.increaseSpawnIndex();
        }
    }
}
