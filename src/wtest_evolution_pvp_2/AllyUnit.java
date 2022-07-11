package wtest_evolution_pvp_2;

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

    boolean tryMove(Direction moveDirection, boolean tryAdjacentDirections) {
        if(uc.canMove(moveDirection)) {
            uc.move(moveDirection);
            return true;
        }
        if(!tryAdjacentDirections)
            return false;
        Direction[] adjacentDirections;
        if(moveDirection == Direction.NORTH)
            adjacentDirections = new Direction[]{Direction.NORTHWEST, Direction.NORTHEAST};
        else if(moveDirection == Direction.NORTHEAST)
            adjacentDirections = new Direction[]{Direction.NORTH, Direction.EAST};
        else if(moveDirection == Direction.EAST)
            adjacentDirections = new Direction[]{Direction.NORTHEAST, Direction.SOUTHEAST};
        else if(moveDirection == Direction.SOUTHEAST)
            adjacentDirections = new Direction[]{Direction.EAST, Direction.SOUTH};
        else if(moveDirection == Direction.SOUTH)
            adjacentDirections = new Direction[]{Direction.SOUTHEAST, Direction.SOUTHWEST};
        else if(moveDirection == Direction.SOUTHWEST)
            adjacentDirections = new Direction[]{Direction.SOUTH, Direction.WEST};
        else if(moveDirection == Direction.WEST)
            adjacentDirections = new Direction[]{Direction.SOUTHWEST, Direction.NORTHWEST};
        else
            adjacentDirections = new Direction[]{Direction.WEST, Direction.NORTH};
        for(Direction direction : adjacentDirections) {
            if(uc.canMove(direction)) {
                uc.move(direction);
                return true;
            }
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