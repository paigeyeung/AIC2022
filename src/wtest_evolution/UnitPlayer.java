package wtest_evolution;

import aic2022.user.*;

public class UnitPlayer {
    UnitController uc;
    public void run(UnitController uc) {
        this.uc = uc;

        UnitType type = uc.getType();

        AllyUnit u = null;

        if(type == UnitType.BASE) u = new Base(uc);
        else u = new Troop(uc);

        boolean firstTurn = true;
        while(true) {
            if(u != null) {
                if(firstTurn) {
                    u.runFirstTurn();
                    firstTurn = false;
                }
                u.run();
            }
            uc.yield();
        }
    }
}

