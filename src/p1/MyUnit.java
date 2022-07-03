package p1;

import aic2022.user.*;
public abstract class MyUnit {

    UnitController uc;
    UnitType myType;
    Team opponent;

    Communication communication;

    MyUnit(UnitController uc){
        this.uc = uc;
        myType = uc.getType();
        opponent = uc.getOpponent();

        communication = new Communication(uc);
    }

    abstract void runFirstTurn();
    abstract void run();
}