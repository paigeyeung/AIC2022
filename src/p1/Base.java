package p1;

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
        communication.initializeBoundaries();
        communication.lookForMapBoundaries();
    }

    void run() {
        communication.downloadMapBoundariesAndEnemyBase();
        Direction dir = getRandomDirection();

        if (uc.canSpawn(UnitType.EXPLORER, dir) &&
                (explorersSpawned < 3 || explorersSpawned < 0.1*totalSpawned)) {
            uc.spawn(UnitType.EXPLORER, dir);
            explorersSpawned++;
            totalSpawned++;
            uc.println("BASE: Explorer spawned");
        }
        else if (uc.canSpawn(UnitType.BARBARIAN, dir)) {
            uc.spawn(UnitType.BARBARIAN, dir);
            barbariansSpawned++;
            totalSpawned++;
            uc.println("BASE: Barbarian spawned");
        }

        uc.println("BASE: Total spawned (Explorers | Barbarians): " + explorersSpawned + " | " + barbariansSpawned);
    }
}
