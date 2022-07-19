package wtest_abilities;

import aic2022.user.*;

public class UnitPlayer {
    UnitController uc;
    public void run(UnitController uc) {
        this.uc = uc;

        UnitType type = uc.getType();

        AllyUnit u = null;

        if(type == UnitType.BASE) u = new Base(uc);
        else if(type == UnitType.EXPLORER) u = new Explorer(uc);
        else if(type == UnitType.MAGE) u = new Mage(uc);

        boolean firstTurn = true;
        while(true) {
            if(u != null) {
                if(firstTurn) {
                    u.runFirstTurn();
                    firstTurn = false;
                }
                u.runBefore();
                u.run();
                u.runAfter();
            }
            uc.yield();
        }
    }
}

