package wtest_evolution;

import aic2022.user.*;
public abstract class AllyUnit {
    UnitController uc;
    Communication communication;

    Team ally, neutral, opponent;
    UnitType selfType;
    int selfAttackRange, selfMinAttackRange;

    AllyUnit(UnitController uc){
        this.uc = uc;
        communication = new Communication(uc);
        ally = uc.getTeam();
        neutral = Team.NEUTRAL;
        opponent = uc.getOpponent();
        selfType = uc.getType();
        selfAttackRange = (int)selfType.getStat(UnitStat.ATTACK_RANGE);
        selfMinAttackRange = (int)selfType.getStat(UnitStat.MIN_ATTACK_RANGE);
        uc.println("selfAttackRange: " + selfAttackRange + ", selfMinAttackRange: " + selfMinAttackRange);
    }

    abstract void runFirstTurn();
    abstract void run();

    void runBefore() {

    }

    void runAfter() {

    }

    boolean tryAttack(Location attackLocation) {
        Location selfLocation = uc.getLocation();
        if (uc.canAttack(attackLocation)) {
            uc.attack(attackLocation);
            uc.setOrientation(selfLocation.directionTo(attackLocation));
            return true;
        }
        return false;
    }

    boolean attackNearbyEnemyOrNeutral() {
        UnitInfo highestAttackScoreUnit = null;
        float highestAttackScore = 0;

        UnitInfo[] visibleEnemies = uc.senseUnits(opponent);
        for (UnitInfo visibleEnemy : visibleEnemies) {
            float attackScore = getAttackScore(visibleEnemy);
            if(attackScore > highestAttackScore) {
                highestAttackScoreUnit = visibleEnemy;
                highestAttackScore = attackScore;
            }

            if(visibleEnemy.getType() == UnitType.BASE) {
                communication.uploadEnemyBase(visibleEnemy.getLocation());
            }
        }

        UnitInfo[] visibleNeutrals = uc.senseUnits(neutral);
        for (UnitInfo visibleNeutral : visibleNeutrals) {
            float attackScore = getAttackScore(visibleNeutral);
            if(attackScore > highestAttackScore) {
                highestAttackScoreUnit = visibleNeutral;
                highestAttackScore = attackScore;
            }
        }

        if(highestAttackScoreUnit != null) {
            uc.println("attackNearbyEnemyOrNeutral highestAttackScoreUnit: " + highestAttackScoreUnit.getLocation() + ", highestAttackScore: " + highestAttackScore);
            tryAttack(highestAttackScoreUnit.getLocation());
            return true;
        }
        uc.println("attackNearbyEnemyOrNeutral highestAttackScoreUnit: null");
        return false;
    }

    float getAttackScore(UnitInfo enemyOrNeutralUnit) {
        Location selfLocation = uc.getLocation();
        int distanceSquared = selfLocation.distanceSquared(enemyOrNeutralUnit.getLocation());
        if(distanceSquared > selfAttackRange || distanceSquared < selfMinAttackRange) {
            return 0;
        }

        if(selfType == UnitType.MAGE)
            return getAttackScoreMage(enemyOrNeutralUnit.getLocation());
        return getAttackScoreRaw(enemyOrNeutralUnit);
    }

    float getAttackScoreRaw(UnitInfo enemyOrNeutralUnit) {
        int health = enemyOrNeutralUnit.getHealth();
        int maxHealth = (int)enemyOrNeutralUnit.getType().getStat(UnitStat.MAX_HEALTH);
        float percentHealth = health / maxHealth;
        return 2 - percentHealth;
    }

    float getAttackScoreMage(Location centerLocation) {
        float totalAttackScore = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                Location location = new Location(centerLocation.x + i, centerLocation.y + j);
                UnitInfo unitAtLocation = uc.senseUnitAtLocation(location);
                if(unitAtLocation == null)
                    continue;
                Team unitTeamAtLocation = unitAtLocation.getTeam();
                if(unitTeamAtLocation.equals(ally))
                    totalAttackScore -= getAttackScoreRaw(unitAtLocation);
                else
                    totalAttackScore += getAttackScoreRaw(unitAtLocation);
            }
        }
        return totalAttackScore;
    }
}