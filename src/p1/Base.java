package p1;

import aic2022.user.*;

public class Base extends MyUnit {
    Communication communication;
    Base(UnitController uc) {
        super(uc);
        communication = new Communication(uc);
    }

    void runFirstTurn() {
        communication.uploadMyBase(uc.getLocation());
    }

    void run() {
        int randomNumber = (int)(Math.random()*8);
        Direction dir = Direction.values()[randomNumber];
        if (uc.canMove(dir)) uc.move(dir);
        if (uc.canSpawn(UnitType.BARBARIAN, dir)) uc.spawn(UnitType.BARBARIAN, dir);
    }
}
