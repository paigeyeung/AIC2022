package wtest1;

import aic2022.user.*;

public class Communication {
    final int INDEX_SPAWN_INDEX = 10000;
    final int INDEX_FORMATION_NUMBER = 10001;
    final int INDEX_FORMATION_CENTER = 10002;
    final int INDEX_FORMATION_DIRECTION = 10003;
    final int INDEX_ACTION = 10004;

    void increaseSpawnIndex() {
        uc.writeOnSharedArray(INDEX_SPAWN_INDEX, uc.readOnSharedArray(INDEX_SPAWN_INDEX) + 1);
    }
    int getSpawnIndex() {
        return uc.readOnSharedArray(INDEX_SPAWN_INDEX);
    }
    int getSelfSpawnIndex() {
        int selfSpawnIndex = getSpawnIndex() - 1;
        uc.println("getSelfSpawnIndex " + selfSpawnIndex);
        return selfSpawnIndex;
    }

    int setFormation() {
        int formationNumber;
        Location formationCenter;
        int formationDirection;
        // These locations only work on Basic1
        if(mapWestBoundary != UNINITIALIZED_BOUNDARY) {
            // Top left base
            formationNumber = 1;
            formationCenter = new Location(allyBaseLocation.x, allyBaseLocation.y - 10);
            formationDirection = 1;
        }
        else {
            // Bottom right base
            formationNumber = 2;
            formationCenter = new Location(allyBaseLocation.x, allyBaseLocation.y + 11);
            formationDirection = 0;
        }
        uc.writeOnSharedArray(INDEX_FORMATION_NUMBER, formationNumber);
        uc.writeOnSharedArray(INDEX_FORMATION_CENTER, encodeLocation(formationCenter));
        uc.writeOnSharedArray(INDEX_FORMATION_DIRECTION, formationDirection);
        uc.println("setFormation formationNumber: " + formationNumber + ", formationCenter: " + formationCenter + ", formationDirection: " + formationDirection);
        return formationNumber;
    }
    int getFormationNumber() {
        return uc.readOnSharedArray(INDEX_FORMATION_NUMBER);
    }
    Location getFormationCenter() {
        return decodeLocation(uc.readOnSharedArray(INDEX_FORMATION_CENTER));
    }
    boolean getFormationDirectionIsRight() {
        return uc.readOnSharedArray(INDEX_FORMATION_DIRECTION) == 0;
    }
    Location getSelfFormationLocation(Formation selfFormation) {
        Location formationCenter = getFormationCenter();
        boolean formationDirectionIsRight = getFormationDirectionIsRight();
        Location selfFormationLocation;
        if(formationDirectionIsRight)
            selfFormationLocation = new Location(formationCenter.x - selfFormation.relativeLocation.x, formationCenter.y + selfFormation.relativeLocation.y);
        else
            selfFormationLocation = new Location(formationCenter.x + selfFormation.relativeLocation.x, formationCenter.y + selfFormation.relativeLocation.y);
        uc.println("getSelfFormationLocation " + selfFormationLocation + ", formationCenter: " + formationCenter + ", formationDirectionIsRight: " + formationDirectionIsRight);
        return selfFormationLocation;
    }
    Location getBattleLocation(Location selfFormationLocation) {
        boolean formationDirectionIsRight = getFormationDirectionIsRight();
        Location battleLocation;
        if(formationDirectionIsRight)
            battleLocation = new Location(selfFormationLocation.x - 8, selfFormationLocation.y);
        else
            battleLocation = new Location(selfFormationLocation.x + 8, selfFormationLocation.y);
        uc.println("getBattleLocation " + battleLocation + ", formationDirectionIsRight: " + formationDirectionIsRight);
        return battleLocation;
    }

    void setAction(int action) {
        uc.writeOnSharedArray(INDEX_ACTION, action);
        uc.println("setAction " + action);
    }
    int getAction() {
        return uc.readOnSharedArray(INDEX_ACTION);
    }



    UnitController uc;

    int visionRangeTilesInOneDirection;
    Communication(UnitController uc) {
        this.uc = uc;

        visionRangeTilesInOneDirection = (int)Math.sqrt(uc.getType().getStat(UnitStat.VISION_RANGE));
        uc.println("Communication visionRangeTilesInOneDirection " + visionRangeTilesInOneDirection);
    }

    /*
    Shared array elements:
    0: Ally base location (location)
    1: Map North boundary (y coordinate)
    2: Map South boundary (y coordinate)
    3: Map West boundary (x coordinate)
    4: Map East boundary (x coordinate)
    5: Enemy base corners (-1 is unknown, -2 is found location,
        1 << 0 is could be North West corner, 1 << 1 is could be North East corner,
        1 << 2 is could be South West corner, 1 << 3 is could be South East corner)
    6: Enemy base location (location)
     */
    final int INDEX_ALLY_BASE_LOCATION = 0;
    final int INDEX_MAP_NORTH_BOUNDARY = 1;
    final int INDEX_MAP_SOUTH_BOUNDARY = 2;
    final int INDEX_MAP_WEST_BOUNDARY = 3;
    final int INDEX_MAP_EAST_BOUNDARY = 4;
    final int INDEX_ENEMY_BASE_CORNERS = 5;
    final int INDEX_ENEMY_BASE_LOCATION = 6;
    final int INDEX_MOVEMENT = 7;


    // Coordinate max value is 79 + 1000 < 2^11
    // Left 16 bits is x, right 16 bits is y
    int encodeLocation(Location location) {
        return location.x << 16 | location.y;
    }
    Location decodeLocation(int encodedLocation) {
        return new Location((encodedLocation >> 16) & 0xffff, encodedLocation & 0xffff);
    }

    Location allyBaseLocation;
    void uploadAllyBase(Location allyBaseLocation) {
        this.allyBaseLocation = allyBaseLocation;
        uc.writeOnSharedArray(INDEX_ALLY_BASE_LOCATION, encodeLocation(allyBaseLocation));
        uc.println("Communication uploadAllyBase " + allyBaseLocation);
    }

    void uploadEnemyBase(Location enemyBaseLocation) {
        this.enemyBaseLocation = enemyBaseLocation;
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_LOCATION, encodeLocation(enemyBaseLocation));
        uc.println("Communication uploadEnemyBase " + enemyBaseLocation);
    }

    void downloadAllyBase() {
        allyBaseLocation = decodeLocation(uc.readOnSharedArray(INDEX_ALLY_BASE_LOCATION));
        uc.println("Communication downloadAllyBase " + allyBaseLocation);
    }

    final int UNINITIALIZED_BOUNDARY = 0xfff;
    int mapNorthBoundary = UNINITIALIZED_BOUNDARY,
            mapSouthBoundary = UNINITIALIZED_BOUNDARY,
            mapWestBoundary = UNINITIALIZED_BOUNDARY,
            mapEastBoundary = UNINITIALIZED_BOUNDARY;
    final int HALF_OF_MIN_MAP = 15;
    int enemyBaseCorners = -1;
    Location enemyBaseLocation;

    void initializeMapBoundariesAndEnemyBaseCorners() {
        uc.writeOnSharedArray(INDEX_MAP_NORTH_BOUNDARY, mapNorthBoundary);
        uc.writeOnSharedArray(INDEX_MAP_SOUTH_BOUNDARY, mapSouthBoundary);
        uc.writeOnSharedArray(INDEX_MAP_WEST_BOUNDARY, mapWestBoundary);
        uc.writeOnSharedArray(INDEX_MAP_EAST_BOUNDARY, mapEastBoundary);
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_CORNERS, enemyBaseCorners);
    }

    void lookForMapBoundaries() {
        Location selfLocation = uc.getLocation();
        if(mapNorthBoundary == UNINITIALIZED_BOUNDARY && uc.isOutOfMap(
                new Location(selfLocation.x, selfLocation.y + visionRangeTilesInOneDirection)))
            foundMapBoundaryRoughly(Direction.NORTH, selfLocation.y + visionRangeTilesInOneDirection);
        if(mapSouthBoundary == UNINITIALIZED_BOUNDARY && uc.isOutOfMap(
                new Location(selfLocation.x, selfLocation.y - visionRangeTilesInOneDirection)))
            foundMapBoundaryRoughly(Direction.SOUTH, selfLocation.y - visionRangeTilesInOneDirection);
        if(mapWestBoundary == UNINITIALIZED_BOUNDARY && uc.isOutOfMap(
                new Location(selfLocation.x - visionRangeTilesInOneDirection, selfLocation.y)))
            foundMapBoundaryRoughly(Direction.WEST, selfLocation.x - visionRangeTilesInOneDirection);
        if(mapEastBoundary == UNINITIALIZED_BOUNDARY && uc.isOutOfMap(
                new Location(selfLocation.x + visionRangeTilesInOneDirection, selfLocation.y)))
            foundMapBoundaryRoughly(Direction.EAST, selfLocation.x + visionRangeTilesInOneDirection);
    }

    void foundMapBoundaryRoughly(Direction direction, int maxBoundary) {
        Location selfLocation = uc.getLocation();
        int boundary = maxBoundary;
        while(true) {
            if(direction.isEqual(Direction.SOUTH) || direction.isEqual(Direction.WEST))
                boundary++;
            else
                boundary--;

            Location newLocation;
            if(direction.isEqual(Direction.NORTH) || direction.isEqual(Direction.SOUTH))
                newLocation = new Location(selfLocation.x, boundary);
            else
                newLocation = new Location(boundary, selfLocation.y);

            if(!uc.isOutOfMap(newLocation)) {
                uploadMapBoundary(direction, boundary);
                return;
            }
        }
    }

    void uploadMapBoundary(Direction direction, int boundary) {
        int index;
        if(direction.isEqual(Direction.NORTH)) {
            index = INDEX_MAP_NORTH_BOUNDARY;
            mapNorthBoundary = boundary;
        }
        else if(direction.isEqual(Direction.SOUTH)) {
            index = INDEX_MAP_SOUTH_BOUNDARY;
            mapSouthBoundary = boundary;
        }
        else if(direction.isEqual(Direction.WEST)) {
            index = INDEX_MAP_WEST_BOUNDARY;
            mapWestBoundary = boundary;
        }
        else if(direction.isEqual(Direction.EAST)) {
            index = INDEX_MAP_EAST_BOUNDARY;
            mapEastBoundary = boundary;
        }
        else {
            uc.println("ERROR: Communication uploadMapBoundary direction not found");
            return;
        }
        uc.writeOnSharedArray(index, boundary);
        uc.println("Communication uploadMapBoundary index: " + index + ", direction: " + direction + ", boundary: " + boundary);
    }

    void guessEnemyBaseCorners() {
        if(allyBaseLocation == null)
            return;
        if(enemyBaseCorners != -1)
            return;

        if(mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY
                && allyBaseLocation.x - mapWestBoundary <= HALF_OF_MIN_MAP
                && mapNorthBoundary - allyBaseLocation.y <= HALF_OF_MIN_MAP)
            uploadEnemyBaseCorners(Direction.NORTHWEST);
        else if(mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY
                && mapEastBoundary - allyBaseLocation.x <= HALF_OF_MIN_MAP
                && mapNorthBoundary - allyBaseLocation.y <= HALF_OF_MIN_MAP)
            uploadEnemyBaseCorners(Direction.NORTHEAST);
        else if(mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY
                && allyBaseLocation.x - mapWestBoundary <= HALF_OF_MIN_MAP
                && allyBaseLocation.y - mapSouthBoundary <= HALF_OF_MIN_MAP)
            uploadEnemyBaseCorners(Direction.SOUTHWEST);
        else if(mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY
                && mapEastBoundary - allyBaseLocation.x <= HALF_OF_MIN_MAP
                && allyBaseLocation.y - mapSouthBoundary <= HALF_OF_MIN_MAP)
            uploadEnemyBaseCorners(Direction.SOUTHEAST);
    }

    void uploadEnemyBaseCorners(Direction allyBaseCorner) {
        enemyBaseCorners = 0xf;
        if(allyBaseCorner.isEqual(Direction.NORTHWEST)) enemyBaseCorners &= ~(1 << 0);
        else if(allyBaseCorner.isEqual(Direction.NORTHEAST)) enemyBaseCorners &= ~(1 << 1);
        else if(allyBaseCorner.isEqual(Direction.SOUTHWEST)) enemyBaseCorners &= ~(1 << 2);
        else if(allyBaseCorner.isEqual(Direction.SOUTHEAST)) enemyBaseCorners &= ~(1 << 3);
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_CORNERS, enemyBaseCorners);
        uc.println("Communication uploadEnemyBaseCorners " + enemyBaseCorners + " (" + Integer.toBinaryString(enemyBaseCorners) + ")");
    }

    void uploadEnemyBaseLocation(Location enemyBaseLocation) {
        enemyBaseCorners = -2;
        this.enemyBaseLocation = enemyBaseLocation;
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_CORNERS, enemyBaseCorners);
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_LOCATION, encodeLocation(enemyBaseLocation));
    }

    void downloadMapBoundariesAndEnemyBase() {
        mapNorthBoundary = uc.readOnSharedArray(INDEX_MAP_NORTH_BOUNDARY);
        mapSouthBoundary = uc.readOnSharedArray(INDEX_MAP_SOUTH_BOUNDARY);
        mapWestBoundary = uc.readOnSharedArray(INDEX_MAP_WEST_BOUNDARY);
        mapEastBoundary = uc.readOnSharedArray(INDEX_MAP_EAST_BOUNDARY);
        uc.println("Communication downloadMapBoundariesAndEnemyBase mapNorthBoundary: " + mapNorthBoundary + ", mapSouthBoundary: " + mapSouthBoundary + ", mapWestBoundary: " + mapWestBoundary + ", mapEastBoundary: " + mapEastBoundary);

        enemyBaseCorners = uc.readOnSharedArray(INDEX_ENEMY_BASE_CORNERS);
        if(enemyBaseCorners == -2) {
            enemyBaseLocation = decodeLocation(uc.readOnSharedArray(INDEX_ENEMY_BASE_LOCATION));
            uc.println("Communication downloadMapBoundariesAndEnemyBase enemyBaseLocation: " + enemyBaseLocation);
        }
        else if(enemyBaseCorners == -1)
            uc.println("Communication downloadMapBoundariesAndEnemyBase enemyBaseCorners: " + enemyBaseCorners);
        else
            uc.println("Communication downloadMapBoundariesAndEnemyBase enemyBaseCorners: " + enemyBaseCorners + " (" + Integer.toBinaryString(enemyBaseCorners) + ")");
    }

    void setExplorerMovementDir() {
        int randomNumber = (int)(Math.random()*8);
        int k = 0;

        Direction[] directions = Direction.values();
        while(foundBoundary(directions[randomNumber]) && k < 10) {
            randomNumber = (int)(Math.random()*8);
            k++;
        }

        uc.writeOnSharedArray(INDEX_MOVEMENT, (randomNumber + 1) << 12);
        uc.println("Communication setExplorerMovementDir: " + directions[randomNumber].toString());
    }

    Direction getExplorerMovementDir() {
        int idx = uc.readOnSharedArray(INDEX_MOVEMENT) >> 12;
        if(idx != 0) return Direction.values()[idx-1];
        return null;
    }

    void setRandomAttackMovementDir() {
        int randomNumber = (int)(Math.random()*8) + 1;
        uc.writeOnSharedArray(INDEX_MOVEMENT, randomNumber << 8);
    }

    void setAttackMovementDir(Direction dir) {
        uc.writeOnSharedArray(INDEX_MOVEMENT, (dir.ordinal() << 8) + 1);
    }

    Direction getAttackMovementDir() {
        int idx = uc.readOnSharedArray(INDEX_MOVEMENT) >> 8;
        if(idx != 0) return Direction.values()[idx-1];
        return null;
    }

    boolean foundBoundary(Direction dir) {
        boolean found = (dir.isEqual(Direction.EAST) && mapEastBoundary != UNINITIALIZED_BOUNDARY) ||
                (dir.isEqual(Direction.NORTH) && mapNorthBoundary != UNINITIALIZED_BOUNDARY) ||
                (dir.isEqual(Direction.SOUTH) && mapSouthBoundary != UNINITIALIZED_BOUNDARY) ||
                (dir.isEqual(Direction.WEST) && mapWestBoundary != UNINITIALIZED_BOUNDARY) ||
                (dir.isEqual(Direction.NORTHEAST) && mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY) ||
                (dir.isEqual(Direction.NORTHWEST) && mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY) ||
                (dir.isEqual(Direction.SOUTHEAST) && mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY) ||
                (dir.isEqual(Direction.SOUTHWEST) && mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY);

        uc.println("Communication found boundary " + dir + "? " + found);
        return found;
    }

    boolean allBoundariesFound() {
        return mapEastBoundary != UNINITIALIZED_BOUNDARY &&
                mapWestBoundary != UNINITIALIZED_BOUNDARY &&
                mapNorthBoundary != UNINITIALIZED_BOUNDARY &&
                mapSouthBoundary != UNINITIALIZED_BOUNDARY;
    }

    int distanceToBoundary(Location location, Direction direction) {
        if(direction.isEqual(Direction.NORTH)) {
            int dist = (mapNorthBoundary - location.y);
            return Integer.min(6400, dist*dist);
        }
        else if(direction.isEqual(Direction.SOUTH)) {
            int dist = (mapSouthBoundary - location.y);
            return Integer.min(6400, dist*dist);
        }
        else if(direction.isEqual(Direction.WEST)) {
            int dist = (mapWestBoundary - location.x);
            return Integer.min(6400, dist*dist);
        }
        else if(direction.isEqual(Direction.EAST)) {
            int dist = (mapEastBoundary - location.x);
            return Integer.min(6400, dist*dist);
        }
        else {
            uc.println("Not a valid boundary direction");
            return Integer.MAX_VALUE;
        }
    }
}