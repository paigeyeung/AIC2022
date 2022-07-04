package wtest1;

import aic2022.user.*;
public abstract class AllyUnit {
    UnitController uc;
    Communication communication;

    AllyUnit(UnitController uc){
        this.uc = uc;
        communication = new Communication(uc);
    }

    abstract void runFirstTurn();
    abstract void run();
}