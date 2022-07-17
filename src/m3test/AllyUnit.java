package m3test;

import aic2022.user.*;
public abstract class AllyUnit {
    int[][] visited = new int[80][80];

    UnitController uc;
    Communication communication;

    Team ally, neutral, opponent;

    Direction[] directions = Direction.values();

    UnitType selfType;
    int selfAttackRange, selfMinAttackRange;

    int turnsNoMove = 0;

    boolean insideDungeon = false;

    boolean moved = false;

    AllyUnit(UnitController uc) {
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

    Direction getRandomMoveDirection() {
        Direction dir = directions[(int) (Math.random() * 8)];
        int k = 0;
        while(!uc.canMove(dir) && k < 10) {
            dir = directions[(int) (Math.random() * 8)];
        }
        return dir;
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
        if (dir != null && uc.canMove(dir))  {
            uc.move(dir);
            moved = true;
            return true;
        }
        return false;
    }

    boolean tryAdjMoves(Direction dir) {
        if(dir == null)
            return false;

        if(tryMove(dir))
            return true;
        else if(tryMove(dir.rotateLeft()))
            return true;
        else if(tryMove(dir.rotateRight()))
            return true;
        return false;
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

    int attackNearbyEnemyOrNeutralOrShrine() {
        UnitInfo highestAttackScoreUnit = null;
        float highestAttackScore = 0;

        UnitInfo[] attackableEnemies = uc.senseUnits(selfAttackRange, opponent);
        for (UnitInfo attackableEnemy : attackableEnemies) {
            float attackScore = getAttackScore(attackableEnemy);
            if(attackScore > highestAttackScore) {
                highestAttackScoreUnit = attackableEnemy;
                highestAttackScore = attackScore;
            }

            if(attackableEnemy.getType() == UnitType.BASE) {
                communication.uploadEnemyBaseLocation(attackableEnemy.getLocation());
            }
        }

        UnitInfo[] attackableNeutrals = uc.senseUnits(selfAttackRange, neutral);
        for (UnitInfo attackableNeutral : attackableNeutrals) {
            float attackScore = getAttackScore(attackableNeutral);
            if(attackScore > highestAttackScore) {
                highestAttackScoreUnit = attackableNeutral;
                highestAttackScore = attackScore;
            }
        }

        if(highestAttackScoreUnit != null) {
            uc.println("attackNearbyEnemyOrNeutralOrShrine highestAttackScoreUnit: " + highestAttackScoreUnit.getLocation() + ", highestAttackScore: " + highestAttackScore);
            if(tryAttack(highestAttackScoreUnit.getLocation())) {
                return 1;
            }
        }

        ShrineInfo[] attackableShrines = uc.senseShrines(selfAttackRange);
        for(ShrineInfo attackableShrine : attackableShrines) {
            if(attackableShrine.getOwner() != ally) {
                uc.println("attackNearbyEnemyOrNeutralOrShrine attackableShrine: " + attackableShrine.getLocation());
                if(tryAttack(attackableShrine.getLocation())) {
                    if(communication.getShrineLocation() != null && attackableShrine.getLocation().isEqual(communication.getShrineLocation())) {
                        communication.resetShrineLocation();
                    }
                    return 2;
                }
                communication.broadcastShrineLocation(attackableShrine.getLocation());
            }
        }

        uc.println("attackNearbyEnemyOrNeutralOrShrine no target found");
        return 0;
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

    UnitInfo getClosestEnemyOrNeutral(boolean considerMinAttackRange) {
        Location selfLocation = uc.getLocation();
        UnitInfo closestUnit = null;
        int closestUnitDistance = Integer.MAX_VALUE;

        UnitInfo[] visibleEnemies = uc.senseUnits(opponent);
        for (UnitInfo visibleEnemy : visibleEnemies) {
            int distance = visibleEnemy.getLocation().distanceSquared(selfLocation);
            if(distance < closestUnitDistance && (!considerMinAttackRange || distance >= selfMinAttackRange)) {
                closestUnit = visibleEnemy;
                closestUnitDistance = distance;
            }
        }

        UnitInfo[] visibleNeutrals = uc.senseUnits(neutral);
        for (UnitInfo visibleNeutral : visibleNeutrals) {
            int distance = visibleNeutral.getLocation().distanceSquared(selfLocation);
            if(distance < closestUnitDistance && (!considerMinAttackRange || distance >= selfMinAttackRange)) {
                closestUnit = visibleNeutral;
                closestUnitDistance = distance;
            }
        }

        return closestUnit;
    }

    ShrineInfo getClosestShrine() {
        ShrineInfo[] visibleShrines = uc.senseShrines();
        for(ShrineInfo visibleShrine : visibleShrines) {
            if(visibleShrine.getOwner() != ally) {
                return visibleShrine;
            }
        }
        return null;
    }

    boolean attackAndMoveToClosestEnemyOrNeutralOrShrine() {
        if(attackNearbyEnemyOrNeutralOrShrine() != 0)
            return true;

        UnitInfo closestEnemyOrNeutral = getClosestEnemyOrNeutral(true);
        if(closestEnemyOrNeutral != null) {
            moveTo(closestEnemyOrNeutral.getLocation());
            return true;
        }

        ShrineInfo closestShrine = getClosestShrine();
        if(closestShrine != null) {
            moveTo(closestShrine.getLocation());
            return true;
        }

        return false;
    }

    void moveTo(Location location) {
        Location myLocation = uc.getLocation();
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
            UnitType type = visibleUnit.getType();
            int unitScore = 0;
            double percentHealth = (double)visibleUnit.getHealth()/type.getStat(UnitStat.MAX_HEALTH);
            if(type == UnitType.EXPLORER) {
                unitScore = 5;
            }
            else if(type == UnitType.BARBARIAN) {
                unitScore = 20;
            }
            else if(type == UnitType.BASE) {
                unitScore = 100;
            }
            else if(type == UnitType.ASSASSIN) {
                unitScore = 50;
            }
            else if(visibleUnit.getType() == UnitType.CLERIC) {
                unitScore = 5;
            }
            else if(visibleUnit.getType() == UnitType.KNIGHT) {
                unitScore += 30;
            }
            else if(visibleUnit.getType() == UnitType.MAGE) {
                unitScore += 50;
            }
            else if(visibleUnit.getType() == UnitType.RANGER) {
                unitScore += 15;
            }
            combatScore += (int)(unitScore * percentHealth);
        }
        return combatScore;
    }

    int getAction() {
        int allyCombatScore = getCombatScore(ally);
        int enemyCombatScore = getCombatScore(opponent) + getCombatScore(neutral)/2;
        if (enemyCombatScore > 0.8 * allyCombatScore || (enemyCombatScore > 0 &&
                (uc.getType() == UnitType.RANGER || uc.getType() == UnitType.EXPLORER)) ||
                communication.getHelpLocation() != null) {
            return 0; // Retreat
        }
        else if (allyCombatScore > 1.5 * enemyCombatScore && allyCombatScore > 150) {
            return 3; // Attack
        }
        return 2; // Hold
    }

    boolean openNearbyChests() {
        ChestInfo[] chests = uc.senseChests(2);
        if(chests.length > 0) {
            for(ChestInfo chest : chests) {
                Location chestLocation = chest.getLocation();
                Direction openDirection = uc.getLocation().directionTo(chestLocation);
                if(uc.canOpenChest(openDirection)) {
                    uc.openChest(openDirection);
                    return true;
                }
            }
        }
        return false;
    }

    boolean tryEnterDungeon() {
        Location[] dungeonEntrances = uc.senseVisibleTiles(2, TileType.DUNGEON_ENTRANCE);
        if(dungeonEntrances.length > 0) {
            uc.println("Sensed dungeon entrance");
            for (Location entrance : dungeonEntrances) {
                Direction dirToEntrance = uc.getLocation().directionTo(entrance);
                for (Direction exit : directions) {
                    if (uc.canEnterDungeon(dirToEntrance, exit)) {
                        uc.println("Entering dungeon from direction " + dirToEntrance + ", exit " + exit);
                        uc.enterDungeon(dirToEntrance, exit);
                        communication.broadcastEntranceLocation(entrance);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    ChestInfo findClosestChest() {
        ChestInfo[] chests = uc.senseChests();
        int minDist = Integer.MAX_VALUE;
        ChestInfo closestChest = null;
        Location location = uc.getLocation();
        if(chests.length > 0) {
            for(ChestInfo chest : chests) {
                Location chestLocation = chest.getLocation();
                int newDist = location.distanceSquared(chest.getLocation());
                if(newDist < minDist && (chest.getGold() > 0 || chest.getReputation() > 0)) {
                    minDist = newDist - chest.getGold()/10 - chest.getReputation()/10;
                    closestChest = chest;
                }
            }
        }
        uc.println("Closest chest found is " + closestChest);
        return closestChest;
    }

    int distanceSquaredToClosestChest() {
        ChestInfo chest = findClosestChest();
        if(chest == null) { return Integer.MAX_VALUE; }
        return uc.getLocation().distanceSquared(chest.getLocation());
    }
}