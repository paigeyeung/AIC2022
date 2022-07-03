package p1;

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
    0: Ally base location
    1: Map North boundary
    2: Map South boundary
    3: Map West boundary
    4: Map East boundary
     */
    final int INDEX_ALLY_BASE_LOCATION = 0;
    final int INDEX_MAP_NORTH_BOUNDARY = 1;
    final int INDEX_MAP_SOUTH_BOUNDARY = 2;
    final int INDEX_MAP_WEST_BOUNDARY = 3;
    final int INDEX_MAP_EAST_BOUNDARY = 4;
//    final int INDEX_ENEMY_BASE_

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

    int mapNorthBoundary = 0, mapSouthBoundary = 0, mapWestBoundary = 0, mapEastBoundary = 0; // 0 means uninitialized
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
                return;
            }
        }
    }
    void uploadMapBoundary(Direction direction, int boundary) {
        int index;
        if(direction.isEqual(Direction.NORTH))
            index = INDEX_MAP_NORTH_BOUNDARY;
        else if(direction.isEqual(Direction.SOUTH))
            index = INDEX_MAP_SOUTH_BOUNDARY;
        else if(direction.isEqual(Direction.WEST))
            index = INDEX_MAP_WEST_BOUNDARY;
        else if(direction.isEqual(Direction.EAST))
            index = INDEX_MAP_EAST_BOUNDARY;
        else {
            uc.println("ERROR: Communication uploadMapBoundary direction not found");
            return;
        }
        uc.writeOnSharedArray(index, boundary);
        uc.println("Communication uploadMapBoundary index: " + index + ", direction: " + direction + ", boundary: " + boundary);
    }
    void downloadMapBoundaries() {
        mapNorthBoundary = uc.readOnSharedArray(INDEX_MAP_NORTH_BOUNDARY);
        mapSouthBoundary = uc.readOnSharedArray(INDEX_MAP_SOUTH_BOUNDARY);
        mapWestBoundary = uc.readOnSharedArray(INDEX_MAP_WEST_BOUNDARY);
        mapEastBoundary = uc.readOnSharedArray(INDEX_MAP_EAST_BOUNDARY);
        uc.println("Communication downloadMapBoundaries mapNorthBoundary: " + mapNorthBoundary + ", mapSouthBoundary: " + mapSouthBoundary + ", mapWestBoundary: " + mapWestBoundary + ", mapEastBoundary: " + mapEastBoundary);
    }
}