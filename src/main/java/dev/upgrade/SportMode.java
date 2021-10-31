package dev.upgrade;

import dev.upgrade.acl.SportCharacteristics;

public class SportMode implements GearboxMode {
    private final SportCharacteristics characteristics;
    private final Kickdown lightKickdown;
    private final Kickdown heavyKickdown;

    public SportMode(SportCharacteristics characteristics) {
        this.characteristics = characteristics;
        this.lightKickdown = new Kickdown(characteristics.getThresholdLightKickdown());
        this.heavyKickdown = new Kickdown(characteristics.getThresholdHeavyickdown());

    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (heavyKickdown.isKickdown(threshold)) {
            return GearAction.doubleReduce();
        } else if (lightKickdown.isKickdown(threshold)) {
            return GearAction.reduce();
        } else {
            if (currentRpm.isGreaterThan(characteristics.getRiseGearWhileAccelerating())) {
                return GearAction.riseGear();
            } else if (currentRpm.isLowerThan(characteristics.getReduceGearWhileSlowlyAccelerating())) {
                return GearAction.reduce();
            }
        }

        return GearAction.nothing();
    }
}
