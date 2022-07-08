package wtest_evolution;

import aic2022.user.*;

public class Base extends AllyUnit {
    int lastTurnHealth;
    int turnsNoAllyAlive = 0;

    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        lastTurnHealth = uc.getInfo().getHealth();

        communication.uploadAllyBase(uc.getLocation());
        communication.initializeBoundaries();
        communication.lookForMapBoundaries();
    }

    void run() {
        if(uc.getRound() == 0)
            uc.spawn(UnitType.EXPLORER, Direction.SOUTH);

        communication.addScore(-1);

        int health = uc.getInfo().getHealth();
        int tookDamage = lastTurnHealth - health;
        if(tookDamage != 0) {
            communication.addScore(-tookDamage * 10);
            lastTurnHealth = health;
        }

        int numAlliesAlive = communication.getNumAlliesAlive();
        if(numAlliesAlive == 0) {
            turnsNoAllyAlive++;
            if(turnsNoAllyAlive >= 3) {
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
