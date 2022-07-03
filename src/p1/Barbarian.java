package p1;

import aic2022.user.*;

public class Barbarian extends MyUnit {
    Barbarian(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadMyBase();
        communication.downloadMapBoundaries();
    }

    void run() {
        UnitInfo[] visibleEnemies = uc.senseUnits(opponent);
        for (int i = 0; i < visibleEnemies.length; ++i) {
            if (uc.canAttack(visibleEnemies[i].getLocation())) uc.attack(visibleEnemies[i].getLocation());
        }
    }
}