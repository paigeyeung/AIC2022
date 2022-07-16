package m2;

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
    5: Corner tracking status (0 is don't know anything,
        1 is know ally base corner and guessing enemy base corners, 2 is know enemy base location)
    6: Ally base corner (-1 is unknown, 0 is North West corner, 1 is North East corner,
        2 is South West corner, 3 is South East corner)
    7: Enemy base corners (-1 is unknown,
        1 << 0 is could be North West corner, 1 << 1 is could be North East corner,
        1 << 2 is could be South West corner, 1 << 3 is could be South East corner)
    8: Enemy base location (location)
     */
    final int INDEX_ALLY_BASE_LOCATION = 0;
    final int INDEX_MAP_NORTH_BOUNDARY = 1;
    final int INDEX_MAP_SOUTH_BOUNDARY = 2;
    final int INDEX_MAP_WEST_BOUNDARY = 3;
    final int INDEX_MAP_EAST_BOUNDARY = 4;
    final int INDEX_CORNER_TRACKING_STATUS = 5;
    final int INDEX_ALLY_BASE_CORNER = 6;
    final int INDEX_ENEMY_BASE_CORNERS = 7;
    final int INDEX_ENEMY_BASE_LOCATION = 8;
    final int INDEX_MOVEMENT = 9;
    final int INDEX_CALL_FOR_HELP = 10;
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

    void downloadAllyBase() {
        allyBaseLocation = decodeLocation(uc.readOnSharedArray(INDEX_ALLY_BASE_LOCATION));
        uc.println("Communication downloadAllyBase " + allyBaseLocation);
    }

    final int UNINITIALIZED_BOUNDARY = 0xfff;
    final int HALF_OF_MIN_MAP = 15;
    int mapNorthBoundary = UNINITIALIZED_BOUNDARY,
            mapSouthBoundary = UNINITIALIZED_BOUNDARY,
            mapWestBoundary = UNINITIALIZED_BOUNDARY,
            mapEastBoundary = UNINITIALIZED_BOUNDARY;
    int cornerTrackingStatus = 0;
    int allyBaseCorner = -1;
    int enemyBaseCorners = -1;
    Location enemyBaseLocation;

    void initializeMapBoundariesAndCornerTracking() {
        uc.writeOnSharedArray(INDEX_MAP_NORTH_BOUNDARY, mapNorthBoundary);
        uc.writeOnSharedArray(INDEX_MAP_SOUTH_BOUNDARY, mapSouthBoundary);
        uc.writeOnSharedArray(INDEX_MAP_WEST_BOUNDARY, mapWestBoundary);
        uc.writeOnSharedArray(INDEX_MAP_EAST_BOUNDARY, mapEastBoundary);

        uc.writeOnSharedArray(INDEX_CORNER_TRACKING_STATUS, cornerTrackingStatus);
        uc.writeOnSharedArray(INDEX_ALLY_BASE_CORNER, allyBaseCorner);
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
                checkForCornerUpdates();
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

    void determineAllyBaseCornerFrom2Boundaries() {
        if(allyBaseLocation == null)
            return;
        if(cornerTrackingStatus != 0)
            return;

        if(mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY
                && allyBaseLocation.x - mapWestBoundary <= HALF_OF_MIN_MAP
                && mapNorthBoundary - allyBaseLocation.y <= HALF_OF_MIN_MAP)
            uploadAllyBaseCorner(Direction.NORTHWEST);
        else if(mapNorthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY
                && mapEastBoundary - allyBaseLocation.x <= HALF_OF_MIN_MAP
                && mapNorthBoundary - allyBaseLocation.y <= HALF_OF_MIN_MAP)
            uploadAllyBaseCorner(Direction.NORTHEAST);
        else if(mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapWestBoundary != UNINITIALIZED_BOUNDARY
                && allyBaseLocation.x - mapWestBoundary <= HALF_OF_MIN_MAP
                && allyBaseLocation.y - mapSouthBoundary <= HALF_OF_MIN_MAP)
            uploadAllyBaseCorner(Direction.SOUTHWEST);
        else if(mapSouthBoundary != UNINITIALIZED_BOUNDARY && mapEastBoundary != UNINITIALIZED_BOUNDARY
                && mapEastBoundary - allyBaseLocation.x <= HALF_OF_MIN_MAP
                && allyBaseLocation.y - mapSouthBoundary <= HALF_OF_MIN_MAP)
            uploadAllyBaseCorner(Direction.SOUTHEAST);
    }

    void determineAllyBaseCornerFrom4Boundaries() {
        if(allyBaseLocation == null)
            return;
        if(cornerTrackingStatus != 0)
            return;

        int allyBaseDistanceFromNorth = mapNorthBoundary - allyBaseLocation.y;
        int allyBaseDistanceFromSouth = allyBaseLocation.y - mapSouthBoundary;
        int allyBaseDistanceFromWest = allyBaseLocation.x - mapWestBoundary;
        int allyBaseDistanceFromEast = mapEastBoundary - allyBaseLocation.x;

        if(allyBaseDistanceFromNorth > allyBaseDistanceFromSouth) {
            if(allyBaseDistanceFromWest > allyBaseDistanceFromEast)
                uploadAllyBaseCorner(Direction.NORTHWEST);
            else
                uploadAllyBaseCorner(Direction.NORTHEAST);
        }
        else {
            if(allyBaseDistanceFromWest > allyBaseDistanceFromEast)
                uploadAllyBaseCorner(Direction.SOUTHWEST);
            else
                uploadAllyBaseCorner(Direction.SOUTHEAST);
        }
    }

    void checkForCornerUpdates() {
        if(cornerTrackingStatus == 0 && allBoundariesFound()) {
            determineAllyBaseCornerFrom4Boundaries();
        }
    }

    void uploadAllyBaseCorner(Direction corner) {
        if(corner.isEqual(Direction.NORTHWEST))
            allyBaseCorner = 0;
        else if(corner.isEqual(Direction.NORTHEAST))
            allyBaseCorner = 1;
        else if(corner.isEqual(Direction.SOUTHWEST))
            allyBaseCorner = 2;
        else if(corner.isEqual(Direction.SOUTHEAST))
            allyBaseCorner = 3;
        else {
            uc.println("ERROR: Communication uploadAllyBaseCorner invalid corner " + corner);
            return;
        }

        uc.writeOnSharedArray(INDEX_ALLY_BASE_CORNER, allyBaseCorner);
        uc.println("Communication uploadAllyBaseCorner " + corner);

        cornerTrackingStatus = 1;
        uc.writeOnSharedArray(INDEX_CORNER_TRACKING_STATUS, cornerTrackingStatus);
        uc.println("Communication uploadAllyBaseCorner cornerTrackingStatus: " + cornerTrackingStatus);

        uploadEliminatedEnemyBaseCorner(corner);
    }

    void uploadEliminatedEnemyBaseCorner(Direction corner) {
        if(cornerTrackingStatus != 1)
            return;

        if(enemyBaseCorners == -1)
            enemyBaseCorners = 0xf;

        if(corner.isEqual(Direction.NORTHWEST))
            enemyBaseCorners &= ~(1 << 0);
        else if(corner.isEqual(Direction.NORTHEAST))
            enemyBaseCorners &= ~(1 << 1);
        else if(corner.isEqual(Direction.SOUTHWEST))
            enemyBaseCorners &= ~(1 << 2);
        else if(corner.isEqual(Direction.SOUTHEAST))
            enemyBaseCorners &= ~(1 << 3);
        else {
            uc.println("ERROR: Communication uploadEliminatedEnemyBaseCorner invalid corner " + corner);
            return;
        }

        uc.writeOnSharedArray(INDEX_ENEMY_BASE_CORNERS, enemyBaseCorners);
        uc.println("Communication uploadEliminatedEnemyBaseCorner corner: " + corner + ", enemyBaseCorners: " + enemyBaseCorners + " (" + Integer.toBinaryString(enemyBaseCorners) + ")");

        if(getNumPossibleEnemyBaseCorners() == 1) {
            Direction enemyBaseCorner = getPossibleEnemyBaseCorner();
            Location enemyBaseLocation = getEnemyBaseLocationIfEnemyBaseIsInCorner(enemyBaseCorner);
            if(enemyBaseLocation != null)
                uploadEnemyBaseLocation(enemyBaseLocation);
        }
    }

    Direction getAllyBaseCorner() {
        if(cornerTrackingStatus != 1)
            return null;

        if(allyBaseCorner == 0)
            return Direction.NORTHWEST;
        if(allyBaseCorner == 1)
            return Direction.NORTHEAST;
        if(allyBaseCorner == 2)
            return Direction.SOUTHWEST;
        if(allyBaseCorner == 3)
            return Direction.SOUTHEAST;

        return null;
    }

    Location getEnemyBaseLocationIfEnemyBaseIsInCorner(Direction enemyBaseCorner) {
        if(cornerTrackingStatus != 1)
            return null;

        Direction allyBaseCorner = getAllyBaseCorner();
        Direction horizontalReflectionCorner, verticalReflectionCorner, rotationalCorner;
        if(allyBaseCorner.isEqual(Direction.NORTHWEST)) {
            horizontalReflectionCorner = Direction.SOUTHWEST;
            verticalReflectionCorner = Direction.NORTHEAST;
            rotationalCorner = Direction.SOUTHEAST;
        }
        else if(allyBaseCorner.isEqual(Direction.NORTHEAST)) {
            horizontalReflectionCorner = Direction.SOUTHEAST;
            verticalReflectionCorner = Direction.NORTHWEST;
            rotationalCorner = Direction.SOUTHWEST;
        }
        else if(allyBaseCorner.isEqual(Direction.SOUTHWEST)) {
            horizontalReflectionCorner = Direction.NORTHWEST;
            verticalReflectionCorner = Direction.SOUTHEAST;
            rotationalCorner = Direction.NORTHEAST;
        }
        else if(allyBaseCorner.isEqual(Direction.SOUTHEAST)) {
            horizontalReflectionCorner = Direction.NORTHEAST;
            verticalReflectionCorner = Direction.SOUTHWEST;
            rotationalCorner = Direction.NORTHWEST;
        }
        else {
            uc.println("Communication getEnemyBaseLocationsIfEnemyBaseIsInCorner invalid allyBaseCorner " + allyBaseCorner);
            return null;
        }

        int x = allyBaseLocation.x;
        int y = allyBaseLocation.y;
        if(enemyBaseCorner.isEqual(horizontalReflectionCorner)) {
            if(mapNorthBoundary == UNINITIALIZED_BOUNDARY
                    || mapSouthBoundary == UNINITIALIZED_BOUNDARY)
                return null;

            if(allyBaseCorner.isEqual(Direction.NORTHWEST)
                    || allyBaseCorner.isEqual(Direction.NORTHEAST))
                y = mapSouthBoundary + (mapNorthBoundary - allyBaseLocation.y);
            else
                y = mapNorthBoundary - (allyBaseLocation.y - mapSouthBoundary);
        }
        if(enemyBaseCorner.isEqual(verticalReflectionCorner)) {
            if(mapWestBoundary == UNINITIALIZED_BOUNDARY
                    || mapEastBoundary == UNINITIALIZED_BOUNDARY)
                return null;

            if(allyBaseCorner.isEqual(Direction.NORTHWEST)
                    || allyBaseCorner.isEqual(Direction.SOUTHWEST))
                x = mapEastBoundary - (allyBaseLocation.x - mapWestBoundary);
            else
                x = mapWestBoundary + (mapEastBoundary - allyBaseLocation.x);
        }
        if(enemyBaseCorner.isEqual(rotationalCorner)) {
            if(!allBoundariesFound())
                return null;

            if(allyBaseCorner.isEqual(Direction.NORTHWEST)) {
                x = mapEastBoundary - (allyBaseLocation.x - mapWestBoundary);
                y = mapSouthBoundary + (mapNorthBoundary - allyBaseLocation.y);
            }
            else if(allyBaseCorner.isEqual(Direction.NORTHEAST)) {
                x = mapWestBoundary + (mapEastBoundary - allyBaseLocation.x);
                y = mapSouthBoundary + (mapNorthBoundary - allyBaseLocation.y);
            }
            else if(allyBaseCorner.isEqual(Direction.SOUTHWEST)) {
                x = mapEastBoundary - (allyBaseLocation.x - mapWestBoundary);
                y = mapNorthBoundary - (allyBaseLocation.y - mapSouthBoundary);
            }
            else {
                x = mapWestBoundary + (mapEastBoundary - allyBaseLocation.x);
                y = mapNorthBoundary - (allyBaseLocation.y - mapSouthBoundary);
            }
        }
        return new Location(x, y);
    }

    void lookForEnemyBase() {
        if(cornerTrackingStatus != 1)
            return;

        for(int i = 0; i < 4; i++) {
            if (((enemyBaseCorners >> i) & 1) == 1) {
                Direction enemyBaseCorner;
                if(i == 0)
                    enemyBaseCorner = Direction.NORTHWEST;
                else if(i == 1)
                    enemyBaseCorner = Direction.NORTHEAST;
                else if(i == 2)
                    enemyBaseCorner = Direction.SOUTHWEST;
                else
                    enemyBaseCorner = Direction.SOUTHEAST;

                Location expectedEnemyBaseLocation = getEnemyBaseLocationIfEnemyBaseIsInCorner(enemyBaseCorner);
                if(expectedEnemyBaseLocation != null && uc.canSenseLocation(expectedEnemyBaseLocation)) {
                    UnitInfo unit = uc.senseUnitAtLocation(expectedEnemyBaseLocation);
                    if(unit == null || unit.getType() != UnitType.BASE) {
                        uploadEliminatedEnemyBaseCorner(enemyBaseCorner);
                    }
                }
            }
        }
    }

    int getNumPossibleEnemyBaseCorners() {
        if(cornerTrackingStatus != 1)
            return -1;

        int numPossibleEnemyBaseCorners = 0;
        for(int i = 0; i < 4; i++) {
            if (((enemyBaseCorners >> i) & 1) == 1) {
                numPossibleEnemyBaseCorners++;
            }
        }
        return numPossibleEnemyBaseCorners;
    }

    Direction getPossibleEnemyBaseCorner() {
        if(cornerTrackingStatus == 0) {
            if(mapNorthBoundary == UNINITIALIZED_BOUNDARY && mapWestBoundary == UNINITIALIZED_BOUNDARY)
                return Direction.NORTHWEST;
            if(mapNorthBoundary == UNINITIALIZED_BOUNDARY && mapEastBoundary == UNINITIALIZED_BOUNDARY)
                return Direction.NORTHEAST;
            if(mapSouthBoundary == UNINITIALIZED_BOUNDARY && mapWestBoundary == UNINITIALIZED_BOUNDARY)
                return Direction.SOUTHWEST;
            if(mapSouthBoundary == UNINITIALIZED_BOUNDARY && mapEastBoundary == UNINITIALIZED_BOUNDARY)
                return Direction.SOUTHEAST;
        }

        if(cornerTrackingStatus == 1) {
            for(int i = 0; i < 4; i++) {
                if (((enemyBaseCorners >> i) & 1) == 1) {
                    if(i == 0)
                        return Direction.NORTHWEST;
                    if(i == 1)
                        return Direction.NORTHEAST;
                    if(i == 2)
                        return Direction.SOUTHWEST;
                    if(i == 3)
                        return Direction.SOUTHEAST;
                }
            }
        }

        return null;
    }

    void uploadEnemyBaseLocation(Location enemyBaseLocation) {
        cornerTrackingStatus = 2;
        uc.writeOnSharedArray(INDEX_CORNER_TRACKING_STATUS, cornerTrackingStatus);
        this.enemyBaseLocation = enemyBaseLocation;
        uc.writeOnSharedArray(INDEX_ENEMY_BASE_LOCATION, encodeLocation(enemyBaseLocation));
        uc.println("Communication uploadEnemyBaseLocation " + enemyBaseLocation);
    }

    void downloadMapBoundariesAndCornerTracking() {
        mapNorthBoundary = uc.readOnSharedArray(INDEX_MAP_NORTH_BOUNDARY);
        mapSouthBoundary = uc.readOnSharedArray(INDEX_MAP_SOUTH_BOUNDARY);
        mapWestBoundary = uc.readOnSharedArray(INDEX_MAP_WEST_BOUNDARY);
        mapEastBoundary = uc.readOnSharedArray(INDEX_MAP_EAST_BOUNDARY);
        uc.println("Communication downloadMapBoundariesAndEnemyBase mapNorthBoundary: " + mapNorthBoundary + ", mapSouthBoundary: " + mapSouthBoundary + ", mapWestBoundary: " + mapWestBoundary + ", mapEastBoundary: " + mapEastBoundary);

        cornerTrackingStatus = uc.readOnSharedArray(INDEX_CORNER_TRACKING_STATUS);
        uc.println("Communication downloadMapBoundariesAndEnemyBase cornerTrackingStatus: " + cornerTrackingStatus);
        if(cornerTrackingStatus == 1) {
            allyBaseCorner = uc.readOnSharedArray(INDEX_ALLY_BASE_CORNER);
            enemyBaseCorners = uc.readOnSharedArray(INDEX_ENEMY_BASE_CORNERS);
            uc.println("Communication downloadMapBoundariesAndEnemyBase allyBaseCorner: " + allyBaseCorner + ", enemyBaseCorners: " + enemyBaseCorners + " (" + Integer.toBinaryString(enemyBaseCorners) + ")");
        }
        else if(cornerTrackingStatus == 2) {
            enemyBaseLocation = decodeLocation(uc.readOnSharedArray(INDEX_ENEMY_BASE_LOCATION));
            uc.println("Communication downloadMapBoundariesAndEnemyBase enemyBaseLocation: " + enemyBaseLocation);
        }
    }

    Direction setExplorerMovementDir() {
        int randomNumber = (int)(Math.random()*8);
        int k = 0;

        Direction[] directions = Direction.values();
        while(foundBoundary(directions[randomNumber])
                && k < 10) {
            randomNumber = (int)(Math.random()*8);
            k++;
        }

        uc.writeOnSharedArray(INDEX_MOVEMENT, (randomNumber + 1) << 12);
        uc.println("Communication setExplorerMovementDir: " + directions[randomNumber].toString());
        return directions[randomNumber];
    }

    Direction getExplorerMovementDir() {
        int idx = uc.readOnSharedArray(INDEX_MOVEMENT) >> 12;
        Direction dir = null;
        if(idx != 0) {
            dir = Direction.values()[idx - 1];
            boolean nsew = isNSEW(dir);
            while ((nsew && distanceToBoundary(uc.getLocation(), dir) < 4) ||
                    (!nsew && distanceToBoundary(uc.getLocation(), dir.rotateRight()) < 4
                            && distanceToBoundary(uc.getLocation(), dir.rotateLeft()) < 4)) {
                dir = setExplorerMovementDir();
            }
        }
        return dir;
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

    Location destOfBoundary(Direction dir) {
        Location selfLocation = uc.getLocation();
        int x = selfLocation.x;
        int y = selfLocation.y;
        if(dir.isEqual(Direction.NORTH) || dir.isEqual(Direction.NORTHEAST) || dir.isEqual(Direction.NORTHWEST))
            y = Math.max(mapNorthBoundary, 1000);
        else if(dir.isEqual(Direction.SOUTH) || dir.isEqual(Direction.SOUTHEAST) || dir.isEqual(Direction.SOUTHWEST))
            y = Math.min(mapSouthBoundary, 0);

        if(dir.isEqual(Direction.EAST) || dir.isEqual(Direction.SOUTHEAST) || dir.isEqual(Direction.NORTHEAST))
            x = Math.max(mapEastBoundary, 1000);
        else if(dir.isEqual(Direction.WEST) || dir.isEqual(Direction.NORTHWEST) || dir.isEqual(Direction.SOUTHWEST))
            x = Math.min(mapWestBoundary, 0);

        return new Location(x, y);
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

    boolean isNSEW(Direction direction) {
        return direction.isEqual(Direction.NORTH) ||
                direction.isEqual(Direction.SOUTH) ||
                direction.isEqual(Direction.EAST) ||
                direction.isEqual(Direction.WEST);
    }

    void callForHelp() {
        uc.writeOnSharedArray(INDEX_CALL_FOR_HELP, encodeLocation(uc.getLocation()));
    }

    Location getHelpLocation() {
        return decodeLocation(uc.readOnSharedArray(INDEX_CALL_FOR_HELP));
    }
}