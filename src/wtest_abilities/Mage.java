package wtest_abilities;

import aic2022.user.*;

public class Mage extends AllyUnit {
    int action = 0;

    Mage(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {}
    void runSecondTurn() {}

    void run() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndCornerTracking();

        Location selfLocation = uc.getLocation();

        int level = uc.getInfo().getLevel();
        if(level == 1) {
            if(uc.canLevelUp()) {
                uc.println("level up");
                uc.levelUp();
            }
            return;
        }

        ShrineInfo[] shrines = uc.senseShrines((int)uc.getType().getStat(UnitStat.ABILITY_1_RANGE));
        for(ShrineInfo shrine : shrines) {
            uc.println("shrine " + shrine.getLocation());
            if(uc.canUseFirstAbility(shrine.getLocation())) {
                uc.println("yes");
                uc.useFirstAbility(shrine.getLocation());
                return;
            }
        }



//        if(communication.cornerTrackingStatus != 2) {
//            return;
//        }
//
//        int distanceSquaredToEnemy = selfLocation.distanceSquared(communication.enemyBaseLocation);
//        boolean inRangeOfEnemy = distanceSquaredToEnemy < uc.getType().getStat(UnitStat.VISION_RANGE);
//
//        uc.println("action " + action + ", inRangeOfEnemy " + inRangeOfEnemy);
//        if(action == 0) {
//            if(uc.canUseFirstAbility(communication.enemyBaseLocation)) {
//                uc.println("using ability");
//                uc.useFirstAbility(communication.enemyBaseLocation);
//                communication.uploadEnemyBaseLocation(selfLocation);
//
//                action = 1;
//            }
//
//            if(!inRangeOfEnemy) {
//                tryAdjMoves(selfLocation.directionTo(communication.enemyBaseLocation));
//            }
//        }
//        else {
//            tryAdjMoves(selfLocation.directionTo(communication.allyBaseLocation));
//
//            if(!inRangeOfEnemy && uc.getInfo().getCurrentAbilityICooldown() == 0) {
//                action = 0;
//            }
//        }
    }
}