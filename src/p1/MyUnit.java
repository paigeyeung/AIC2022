package p1;

import aic2022.user.*;
public abstract class MyUnit {

    UnitController uc;
    Team opponent;

    MyUnit(UnitController uc){
        this.uc = uc;
        opponent = uc.getOpponent();
    }

    abstract void run();

}