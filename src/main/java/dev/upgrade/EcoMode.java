package dev.upgrade;

import dev.upgrade.acl.EcoCharacteristics;

public class EcoMode implements GearboxMode {
    private final RpmRange rpmRange;

    public EcoMode(EcoCharacteristics ecoCharacteristics) {
        this.rpmRange = new RpmRange(ecoCharacteristics.getReduceGearWhileAccelerating(), ecoCharacteristics.getRiseGearWhileAccelerating());
    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (rpmRange.isAbove(currentRpm)) {
            return GearAction.riseGear();
        } else if (rpmRange.isBelow(currentRpm)) {
            return GearAction.reduce();
        }

        return GearAction.nothing();
    }
}
