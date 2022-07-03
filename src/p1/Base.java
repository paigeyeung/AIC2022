package p1;

import aic2022.user.*;

public class Base extends AllyUnit {
    Base(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.uploadAllyBase(uc.getLocation());
        communication.lookForMapBoundaries();
    }

    void run() {
        int randomNumber = (int)(Math.random()*8);
        Direction dir = Direction.values()[randomNumber];
        if (uc.canMove(dir)) uc.move(dir);
        if (uc.canSpawn(UnitType.BARBARIAN, dir)) uc.spawn(UnitType.BARBARIAN, dir);
    }
}
