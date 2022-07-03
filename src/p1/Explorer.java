package p1;

import aic2022.user.*;

public class Explorer extends MyUnit {
    Explorer(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadMyBase();
        communication.downloadMapBoundaries();
    }

    void run() {

    }
}