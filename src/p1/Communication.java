package p1;

import aic2022.user.*;

public class Communication {
    UnitController uc;
    Communication(UnitController uc) {
        this.uc = uc;
    }

    // Coordinate max value is 79 + 1000 < 2^11
    int encodeLocation(Location location) {
        return location.x << 16 | location.y;
    }
    Location decodeLocation(int encodedLocation) {
        return new Location((encodedLocation >> 16) & 0xffff, encodedLocation & 0xffff);
    }

    /*
    Shared array elements:
    0: My base location
     */
    final int INDEX_MY_BASE_LOCATION = 0;

    Location myBaseLocation;
    void uploadMyBase(Location myBaseLocation) {
        this.myBaseLocation = myBaseLocation;
        uc.writeOnSharedArray(INDEX_MY_BASE_LOCATION, encodeLocation(myBaseLocation));
        uc.println("uploadMyBase " + myBaseLocation);
    }
    void downloadMyBase() {
        myBaseLocation = decodeLocation(uc.readOnSharedArray(INDEX_MY_BASE_LOCATION));
        uc.println("downloadMyBase " + myBaseLocation);
    }

    void downloadCriticalUpdates() {

    }

    void downloadNoncriticalUpdates() {

    }
}