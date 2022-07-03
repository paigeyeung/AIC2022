package p1;

import aic2022.user.*;

public class Barbarian extends MyUnit {
    Communication communication;
    Barbarian(UnitController uc) {
        super(uc);
        communication = new Communication(uc);
    }

    void runFirstTurn() {

    }

    void run() {
        UnitInfo[] visibleEnemies = uc.senseUnits(opponent);
        for (int i = 0; i < visibleEnemies.length; ++i) {
            if (uc.canAttack(visibleEnemies[i].getLocation())) uc.attack(visibleEnemies[i].getLocation());
        }
    }
}