package dev.upgrade.gearbox;

import dev.upgrade.characteristics.SportCharacteristics;
import dev.upgrade.shared.Kickdown;
import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.RpmRange;
import dev.upgrade.shared.Threshold;

class SportMode implements GearboxMode {
    private final Kickdown lightKickdown;
    private final Kickdown heavyKickdown;
    private final RpmRange neutralRpmRange;

    SportMode(SportCharacteristics characteristics) {
        this.lightKickdown = new Kickdown(characteristics.getThresholdLightKickdown());
        this.heavyKickdown = new Kickdown(characteristics.getThresholdHeavyKickdown());
        this.neutralRpmRange = new RpmRange(characteristics.getReduceGearWhileSlowlyAccelerating(),
                                            characteristics.getIncreaseGearWhileAccelerating());
    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (heavyKickdown.isKickdown(threshold)) {
            return GearAction.doubleReduce();
        } else if (lightKickdown.isKickdown(threshold)) {
            return GearAction.reduce();
        } else {
            if (neutralRpmRange.isRpmAboveRange(currentRpm)) {
                return GearAction.increaseGear();
            } else if (neutralRpmRange.isRpmBelowRange(currentRpm)) {
                return GearAction.reduce();
            }
        }

        return GearAction.nothing();
    }
}
