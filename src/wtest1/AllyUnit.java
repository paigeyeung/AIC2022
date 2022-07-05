package wtest1;

import aic2022.user.*;
public abstract class AllyUnit {
    int formationGold = 300;
    int formationNumber; // Automatically set by each player
    Formation[] formation; // Automatically set by each player
    Formation[] formation1 = {
            new Formation(new Location(-1, 1), UnitType.EXPLORER),
            new Formation(new Location(0, 1), UnitType.BARBARIAN),
            new Formation(new Location(-1, 0), UnitType.EXPLORER),
            new Formation(new Location(0, 0), UnitType.BARBARIAN),
            new Formation(new Location(-1, -1), UnitType.EXPLORER),
            new Formation(new Location(0, -1), UnitType.BARBARIAN)
    };
    Formation[] formation2 = {
            new Formation(new Location(-1, 1), UnitType.RANGER),
            new Formation(new Location(0, 1), UnitType.MAGE),
            new Formation(new Location(-1, 0), UnitType.RANGER),
            new Formation(new Location(0, 0), UnitType.MAGE)
    };

    int selfSpawnIndex = -1;



    int[][] visited = new int[80][80];
    UnitController uc;
    Team opponent;
    Team ally;

    Communication communication;

    Direction[] directions = Direction.values();

    int turnsNoMove = 0;

    boolean moved = false;

    AllyUnit(UnitController uc){
        this.uc = uc;
        opponent = uc.getOpponent();
        ally = uc.getTeam();
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

    Location getClosestEnemyLocation() {
        Location myLocation = uc.getLocation();
        UnitInfo[] visibleEnemies = uc.senseUnits(opponent);
        Location closestEnemyLocation = null;
        int closestEnemyDistance = Integer.MAX_VALUE;
        for (UnitInfo visibleEnemy : visibleEnemies) {
            int distance = visibleEnemy.getLocation().distanceSquared(myLocation);
            if(distance < closestEnemyDistance) {
                closestEnemyLocation = visibleEnemy.getLocation();
                closestEnemyDistance = distance;
            }

            if(visibleEnemy.getType() == UnitType.BASE) {
                communication.uploadEnemyBase(visibleEnemy.getLocation());
            }
        }
        return closestEnemyLocation;
    }

    void attackAndMoveToClosestEnemy() {
        Location myLocation = uc.getLocation();
        Location closestEnemyLocation = getClosestEnemyLocation();
        if(closestEnemyLocation == null) {
            if(communication.getFormationDirectionIsRight())
                closestEnemyLocation = new Location(myLocation.x - 100, myLocation.y);
            else
                closestEnemyLocation = new Location(myLocation.x + 100, myLocation.y);
        }
        int distanceSquared = myLocation.distanceSquared(closestEnemyLocation);
        int attackRange = (int)uc.getType().getStat(UnitStat.ATTACK_RANGE);
        uc.println("attackAndMoveToClosestEnemy distanceSquared: " + distanceSquared + ", attackRange: " + attackRange);
        if(distanceSquared >= distanceSquared) {
            moveTo(closestEnemyLocation, true, false);
        }
        if(uc.canAttack(closestEnemyLocation)) {
            uc.attack(closestEnemyLocation);
        }
    }

    void moveTo(Location location, boolean moveAfterArrived, boolean onlyMoveInDirection) {
        Location myLocation = uc.getLocation();
        uc.println("moveTo location: " + location + ", myLocation: " + myLocation);

        if(!moveAfterArrived && myLocation.isEqual(location)) {
            uc.println("moveTo arrived");
            return;
        }

        if(onlyMoveInDirection) {
            Direction dir = myLocation.directionTo(location);
            if(uc.canMove(dir)) {
                tryMove(dir);
            }
            return;
        }

        int cost = myLocation.distanceSquared(location) + turnsNoMove * 5 + getVisited(myLocation) * 10;
        Direction dir = null;
        for (Direction d: directions) {
            if(uc.canMove(d)) {
                Location newLocation = myLocation.add(d);
                int directionCost = newLocation.distanceSquared(location) + getVisited(newLocation) * 10;
                if (directionCost < cost) {
                    cost = directionCost;
                    dir = d;
                }
            }
        }

        if (dir != null) {
            tryAdjMoves(dir);
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