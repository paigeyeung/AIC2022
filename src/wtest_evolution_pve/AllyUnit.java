package wtest_evolution_pve;

import aic2022.user.*;
public abstract class AllyUnit {
    boolean loggingOn = true;

    UnitController uc;
    Communication communication;

    Direction[] directions;
    Team ally, neutral, opponent;
    UnitType selfType;
    int selfAttackRange, selfMinAttackRange;

    AllyUnit(UnitController uc){
        this.uc = uc;
        communication = new Communication(uc, loggingOn);
        directions = Direction.values();
        ally = uc.getTeam();
        neutral = Team.NEUTRAL;
        opponent = uc.getOpponent();
        selfType = uc.getType();
        selfAttackRange = (int)selfType.getStat(UnitStat.ATTACK_RANGE);
        selfMinAttackRange = (int)selfType.getStat(UnitStat.MIN_ATTACK_RANGE);
        if(loggingOn) uc.println("selfAttackRange: " + selfAttackRange + ", selfMinAttackRange: " + selfMinAttackRange);
    }

    abstract void runFirstTurn();
    abstract void run();

    boolean tryMove(Direction moveDirection) {
        if (uc.canMove(moveDirection)) {
            uc.move(moveDirection);
            return true;
        }
        return false;
    }

    int tryAttack(Location attackLocation) {
        Location selfLocation = uc.getLocation();
        if (uc.canAttack(attackLocation)) {
            int startingHealth = uc.senseUnitAtLocation(attackLocation).getHealth();
            uc.attack(attackLocation);
            int endingHealth = 0;
            if(uc.senseUnitAtLocation(attackLocation) != null)
                endingHealth = uc.senseUnitAtLocation(attackLocation).getHealth();
            int damage = startingHealth - endingHealth;
            uc.setOrientation(selfLocation.directionTo(attackLocation));
            return damage;
        }
        return 0;
    }

    UnitInfo getNearestEnemyOrNeutral(boolean includeEnemies, boolean includeNeutrals) {
        Location selfLocation = uc.getLocation();

        UnitInfo nearestUnit = null;
        float nearestUnitDistance = Float.MAX_VALUE;

        if(includeEnemies) {
            UnitInfo[] visibleEnemies = uc.senseUnits(opponent);
            for (UnitInfo visibleEnemy : visibleEnemies) {
                float distance = selfLocation.distanceSquared(visibleEnemy.getLocation());
                if(distance < nearestUnitDistance) {
                    nearestUnit = visibleEnemy;
                    nearestUnitDistance = distance;
                }
            }
        }

        if(includeNeutrals) {
            UnitInfo[] visibleNeutrals = uc.senseUnits(neutral);
            for (UnitInfo visibleNeutral : visibleNeutrals) {
                float distance = selfLocation.distanceSquared(visibleNeutral.getLocation());
                if(distance < nearestUnitDistance) {
                    nearestUnit = visibleNeutral;
                    nearestUnitDistance = distance;
                }
            }
        }

        return nearestUnit;
    }
}