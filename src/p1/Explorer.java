package p1;

import aic2022.user.*;

public class Explorer extends MyUnit {
    Communication communication;
    Explorer(UnitController uc) {
        super(uc);
        communication = new Communication(uc);
    }

    void runFirstTurn() {

    }

    void run() {

    }
}