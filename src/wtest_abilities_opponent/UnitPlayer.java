package wtest_abilities_opponent;

import aic2022.user.*;

public class UnitPlayer {
	public void run(UnitController uc) {
		while (true){
			int randomNumber = (int)(Math.random() * 8);
			Direction dir = Direction.values()[randomNumber];

			if (uc.getType() == UnitType.BASE) {
				if (uc.canSpawn(UnitType.BARBARIAN, dir)) {
					uc.spawn(UnitType.BARBARIAN, dir);
				}
			}
			else {
				uc.killSelf();
			}

			uc.yield(); //End of turn
		}
	}
}

