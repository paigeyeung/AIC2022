package m3;

import aic2022.user.*;

public class UnitPlayer {

    UnitController uc;
    public void run(UnitController uc) {
        this.uc = uc;

        UnitType type = uc.getType();

        AllyUnit u = null;

        if(type == UnitType.BASE) u = new Base(uc);
        else if(type == UnitType.EXPLORER) u = new Explorer(uc);
        else if(type == UnitType.BARBARIAN) u = new Barbarian(uc);
        else uc.println("😢🐻‍❄️");

        int turn = 1;
        while(true) {
            if(u != null) {
                if(turn == 1) {
                    u.runFirstTurn();
                }
                else if(turn == 2) {
                    u.runSecondTurn();
                }
                turn++;

                u.runBefore();
                u.run();
                u.runAfter();
            }
            uc.yield();
        }
    }
}

