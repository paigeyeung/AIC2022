package p1;

import aic2022.user.*;
public abstract class AllyUnit {
    
    int[][] visited = new int[80][80];
    UnitController uc;
    Team opponent;

    Communication communication;

    Direction[] directions = Direction.values();

    int turnsNoMove = 0;

    boolean moved = false;

    AllyUnit(UnitController uc){
        this.uc = uc;
        opponent = uc.getOpponent();
        communication = new Communication(uc);
    }

    abstract void runFirstTurn();
    abstract void run();

    void runBefore() {
        Location myLocation = uc.getLocation();
        visited[myLocation.x % 80][myLocation.y % 80]++;
        moved = false;
    }

    void runAfter() {
        if(moved) {
            turnsNoMove = 0;
        }
        else {
            turnsNoMove++;
        }
    }

    int getVisited(Location location) {
        return visited[location.x%80][location.y%80];
    }

    Direction getRandomDirection() {
        return directions[(int) (Math.random() * 8)];
    }

    boolean tryRandomMove() {
        for (int i = 0; i < 10; i++) {
            Direction dir = getRandomDirection();
            if (tryMove(dir)) {
                return true;
            }
        }
        return false;
    }

    boolean tryMove(Direction dir) {
        if (uc.canMove(dir))  {
            uc.move(dir);
            moved = true;
            return true;
        }
        return false;
    }

    boolean tryAdjMoves(Direction dir) {
        if (tryMove(dir))  {
            return true;
        }
        else if(tryMove(dir.rotateLeft())) {
            return true;
        }
        else if(tryMove(dir.rotateRight())) {
            return true;
        }
        return false;
    }

    boolean tryAttack(Location attackLocation) {
        if (uc.canAttack(attackLocation)) {
            uc.attack(attackLocation);
            return true;
        }
        return false;
    }

    void attackNearbyEnemies() {
        UnitInfo[] visibleEnemies = uc.senseUnits(opponent);
        for (UnitInfo visibleEnemy : visibleEnemies) {
            tryAttack(visibleEnemy.getLocation());
            if(visibleEnemy.getType() == UnitType.BASE) {
                communication.uploadEnemyBase(visibleEnemy.getLocation());
            }
        }
    }

    void moveTo(Location location) {
        Location myLocation = uc.getLocation();
        double cost = myLocation.distanceSquared(location) + turnsNoMove * 5 + getVisited(myLocation) * 10;
        Direction dir = null;
        for (Direction d: directions) {
            if(uc.canMove(d)) {
                Location newLocation = myLocation.add(d);
                double directionCost = newLocation.distanceSquared(location) + getVisited(newLocation) * 10;
                if (directionCost < cost) {
                    cost = directionCost;
                    dir = d;
                }
            }
        }

        if (dir != null) {
            tryMove(dir);
        }
    }

    int getCombatScore(Team team) {
        int combatScore = 0;
        UnitInfo[] visibleUnits = uc.senseUnits(team);
        for (UnitInfo visibleUnit : visibleUnits) {
            if(visibleUnit.getType() == UnitType.EXPLORER) {
                combatScore += 5;
            }
            else if(visibleUnit.getType() == UnitType.BARBARIAN) {
                combatScore += 20;
            }
            else if(visibleUnit.getType() == UnitType.BASE) {
                combatScore += 100;
            }
            else if(visibleUnit.getType() == UnitType.ASSASSIN) {
                combatScore += 50;
            }
            else if(visibleUnit.getType() == UnitType.CLERIC) {
                combatScore += 5;
            }
            else if(visibleUnit.getType() == UnitType.KNIGHT) {
                combatScore += 30;
            }
            else if(visibleUnit.getType() == UnitType.MAGE) {
                combatScore += 50;
            }
            else if(visibleUnit.getType() == UnitType.RANGER) {
                combatScore += 15;
            }
        }
        return combatScore;
    }
}