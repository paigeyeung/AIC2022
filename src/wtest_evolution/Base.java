package wtest_evolution;

import aic2022.user.*;

public class Base extends AllyUnit {
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
    }
}
