package p1;

import aic2022.user.*;
public abstract class AllyUnit {

    UnitController uc;
    Team opponent;

    Communication communication;

    AllyUnit(UnitController uc){
        this.uc = uc;
        opponent = uc.getOpponent();

        communication = new Communication(uc);
    }

    abstract void runFirstTurn();
    abstract void run();
}