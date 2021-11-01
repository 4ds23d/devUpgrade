package dev.upgrade;

import dev.upgrade.acl.SportCharacteristics;

public class SportMode implements GearboxMode {
    private final Kickdown lightKickdown;
    private final Kickdown heavyKickdown;
    private final RpmRange rpmRange;

    public SportMode(SportCharacteristics characteristics) {
        this.lightKickdown = new Kickdown(characteristics.getThresholdLightKickdown());
        this.heavyKickdown = new Kickdown(characteristics.getThresholdHeavyKickdown());
        this.rpmRange = new RpmRange(characteristics.getReduceGearWhileSlowlyAccelerating(), characteristics.getRiseGearWhileAccelerating());
    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (heavyKickdown.isKickdown(threshold)) {
            return GearAction.doubleReduce();
        } else if (lightKickdown.isKickdown(threshold)) {
            return GearAction.reduce();
        } else {
            if (rpmRange.isAbove(currentRpm)) {
                return GearAction.riseGear();
            } else if (rpmRange.isBelow(currentRpm)) {
                return GearAction.reduce();
            }
        }

        return GearAction.nothing();
    }
}
