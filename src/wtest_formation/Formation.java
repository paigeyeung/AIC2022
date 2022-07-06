package wtest_formation;

import aic2022.user.*;
public class Formation {
    public Location relativeLocation;
    public UnitType unitType;

    // Assume rightward orientation
    Formation(Location relativeLocation, UnitType unitType) {
        this.relativeLocation = relativeLocation;
        this.unitType = unitType;
    }
}
