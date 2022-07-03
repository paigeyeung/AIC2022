package p1;

import aic2022.user.*;

public class UnitPlayer {

    UnitController uc;

    public void run(UnitController uc) {
        /*Insert here the code that should be executed only at the beginning of the unit's lifespan*/
        this.uc = uc;

        while (true){
            /*Insert here the code that should be executed every round*/
            UnitType type = uc.getType();
            MyUnit u = null;

            if (type == UnitType.BASE) u = new Base(uc);
            else if(type == UnitType.EXPLORER) u = new Explorer(uc);
            else if (type == UnitType.BARBARIAN) u = new Barbarian(uc);
            else {
                uc.println("😢🐻‍❄️");
            }

            if (u != null) u.run();

            uc.yield();
        }
    }
}

