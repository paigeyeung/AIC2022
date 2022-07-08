package wtest_evolution;

import aic2022.user.*;

public class Base extends AllyUnit {
    int turnsNoAllyAlive = 0;

    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.uploadAllyBase(uc.getLocation());
        communication.initializeBoundaries();
        communication.lookForMapBoundaries();
    }

    void run() {
        if(uc.getRound() == 1)
            uc.spawn(UnitType.EXPLORER, Direction.SOUTH);

        int numAlliesAlive = communication.getNumAlliesAlive();
        if(numAlliesAlive == 0) {
            turnsNoAllyAlive++;
            if(turnsNoAllyAlive >= 5) {
                uc.killSelf();
            }
        }
        else {
            turnsNoAllyAlive = 0;
        }
        communication.resetNumAlliesAlive();

//        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral();
//        if(nearestEnemyOrNeutral != null) {
//            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
//            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
//            if(damage != 0)
//                communication.addScore(damage);
//        }
    }
}
