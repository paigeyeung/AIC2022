package p2;

import aic2022.user.*;

public class Communication {
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
    5: Enemy base corner (-1 is unknown, -2 is found location,
        1 << 0 is could be North West corner, 1 << 1 is could be North East corner,
        1 << 2 is could be South West corner, 1 << 3 is could be South East corner)
    6: Enemy base location (location)
     */
    final int INDEX_ALLY_BASE_LOCATION = 0;
    final int INDEX_MAP_NORTH_BOUNDARY = 1;
    final int INDEX_MAP_SOUTH_BOUNDARY = 2;
    final int INDEX_MAP_WEST_BOUNDARY = 3;
    final int INDEX_MAP_EAST_BOUNDARY = 4;
    final int INDEX_ENEMY_BASE_CORNER = 5;
    final int INDEX_ENEMY_BASE_LOCATION = 6;
    final int INDEX_MOVEMENT = 7;
//    final int INDEX_LOCATIONS = 1000;

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
    int enemyBaseCorner = 0; Location enemyBaseLocation;

    void initializeBoundaries() {
        uploadMapBoundary(Direction.EAST, UNINITIALIZED_BOUNDARY);
        uploadMapBoundary(Direction.NORTH, UNINITIALIZED_BOUNDARY);
        uploadMapBoundary(Direction.SOUTH, UNINITIALIZED_BOUNDARY);
        uploadMapBoundary(Direction.WEST, UNINITIALIZED_BOUNDARY);
    }

    void lookForMapBoundaries() {
        Location selfLocation = uc.getLocation();
        if(uc.isOutOfMap(new Location(selfLocation.x, selfLocation.y + visionRangeTilesInOneDirection)))
            foundMapBoundaryRoughly(Direction.NORTH, selfLocation.y + visionRangeTilesInOneDirection);
        if(uc.isOutOfMap(new Location(selfLocation.x, selfLocation.y - visionRangeTilesInOneDirection)))
            foundMapBoundaryRoughly(Direction.SOUTH, selfLocation.y - visionRangeTilesInOneDirection);
        if(uc.isOutOfMap(new Location(selfLocation.x - visionRangeTilesInOneDirection, selfLocation.y)))
            foundMapBoundaryRoughly(Direction.WEST, selfLocation.x - visionRangeTilesInOneDirection);
        if(uc.isOutOfMap(new Location(selfLocation.x + visionRangeTilesInOneDirection, selfLocation.y)))
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
            if(direction.isEqual(Direction.NORTH))
                newLocation = new Location(selfLocation.x, boundary);
            else if(direction.isEqual(Direction.SOUTH))
                newLocation = new Location(selfLocation.x, boundary);
            else if(direction.isEqual(Direction.WEST))
                newLocation = new Location(boundary, selfLocation.y);
            else if(direction.isEqual(Direction.EAST))
                newLocation = new Location(boundary, selfLocation.y);
            else {
                uc.println("ERROR: Communication foundMapBoundaryRoughly direction not found");
                return;
            }

            if(!uc.isOutOfMap(newLocation)) {
                uploadMapBoundary(direction, boundary);
                uc.println("Communication uploaded new map boundary for " + direction + ": " + boundary);
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
    void updateEnemyBaseDirection() {
        if(allyBaseLocation == null)
            return;
        if(enemyBaseCorner != -1)
            return;

        final int requiredDistance = 15;
        // If ally base is close enough to a corner of the map
        if(mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY
                && allyBaseLocation.x - mapWestBoundary <= requiredDistance
                && mapNorthBoundary - allyBaseLocation.y <= requiredDistance)
            uploadEnemyBaseCorner(Direction.NORTHWEST);
        else if(mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY
                && mapEastBoundary - allyBaseLocation.x <= requiredDistance
                && mapNorthBoundary - allyBaseLocation.y <= requiredDistance)
            uploadEnemyBaseCorner(Direction.NORTHEAST);
        else if(mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY
                && allyBaseLocation.x - mapWestBoundary <= requiredDistance
                && allyBaseLocation.y - mapSouthBoundary <= requiredDistance)
            uploadEnemyBaseCorner(Direction.SOUTHWEST);
        else if(mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY
                && mapEastBoundary - allyBaseLocation.x <= requiredDistance
                && allyBaseLocation.y - mapSouthBoundary <= requiredDistance)
            uploadEnemyBaseCorner(Direction.SOUTHEAST);
    }
    void uploadEnemyBaseCorner(Direction allyBaseCorner) {
        Direction guessDirection = allyBaseCorner.opposite();

        if(guessDirection.isEqual(Direction.NORTHWEST)) enemyBaseCorner = 1 << 0;
        else if(guessDirection.isEqual(Direction.NORTHEAST)) enemyBaseCorner = 1 << 1;
        else if(guessDirection.isEqual(Direction.SOUTHWEST)) enemyBaseCorner = 1 << 2;
        else if(guessDirection.isEqual(Direction.SOUTHEAST)) enemyBaseCorner = 1 << 3;

        uc.writeOnSharedArray(INDEX_ENEMY_BASE_CORNER, enemyBaseCorner);
    }

    void uploadEnemyBaseLocation (Location location) {
        enemyBaseLocation = location;
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_CORNER, -2);
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_LOCATION, encodeLocation(location));
    }

    void downloadMapBoundariesAndEnemyBase() {
        mapNorthBoundary = uc.readOnSharedArray(INDEX_MAP_NORTH_BOUNDARY);
        mapSouthBoundary = uc.readOnSharedArray(INDEX_MAP_SOUTH_BOUNDARY);
        mapWestBoundary = uc.readOnSharedArray(INDEX_MAP_WEST_BOUNDARY);
        mapEastBoundary = uc.readOnSharedArray(INDEX_MAP_EAST_BOUNDARY);

        enemyBaseCorner = uc.readOnSharedArray(INDEX_ENEMY_BASE_CORNER);
        if(enemyBaseCorner == -2) {
            enemyBaseLocation = decodeLocation(uc.readOnSharedArray(INDEX_ENEMY_BASE_LOCATION));
        }

        uc.println("Communication downloadMapBoundariesAndEnemyBase mapNorthBoundary: " + mapNorthBoundary + ", mapSouthBoundary: " + mapSouthBoundary + ", mapWestBoundary: " + mapWestBoundary + ", mapEastBoundary: " + mapEastBoundary + ", enemyBaseCorner: " + enemyBaseCorner + (enemyBaseCorner == -2 ? ", enemyBaseLocation: " + enemyBaseLocation : ""));
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