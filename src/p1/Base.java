package p1;

import aic2022.user.*;

public class Base extends MyUnit {
    Base(UnitController uc) {
        super(uc);
    }

    void run() {
        int randomNumber = (int)(Math.random()*8);
        Direction dir = Direction.values()[randomNumber];
        if (uc.canMove(dir)) uc.move(dir);
        if (uc.canSpawn(UnitType.BARBARIAN, dir)) uc.spawn(UnitType.BARBARIAN, dir);
    }
}
