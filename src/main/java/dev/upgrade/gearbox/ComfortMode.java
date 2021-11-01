package dev.upgrade.gearbox;

import dev.upgrade.characteristics.ComfortCharacteristics;
import dev.upgrade.shared.Kickdown;
import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.RpmRange;
import dev.upgrade.shared.Threshold;

class ComfortMode implements GearboxMode {
    private final Kickdown kickdown;
    private final RpmRange neutralRpmRange;

    ComfortMode(ComfortCharacteristics characteristics) {
        this.neutralRpmRange = new RpmRange(characteristics.getReduceGearWhileAccelerating(),
                                            characteristics.getRiseGearWhileAccelerating());
        this.kickdown = new Kickdown(characteristics.getThresholdSoThatIsNoKickdown());
    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (kickdown.isKickdown(threshold)) {
            return GearAction.reduce();
        } else {
            if (neutralRpmRange.isRpmAboveRange(currentRpm)) {
                return GearAction.riseGear();
            } else if (neutralRpmRange.isRpmBelowRange(currentRpm)) {
                return GearAction.reduce();
            }
        }
        return GearAction.nothing();
    }
}
