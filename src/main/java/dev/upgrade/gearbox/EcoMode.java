package dev.upgrade.gearbox;

import dev.upgrade.characteristics.EcoCharacteristics;
import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.RpmRange;
import dev.upgrade.shared.Threshold;

class EcoMode implements GearboxMode {
    private final RpmRange neutralRpmRange;

    EcoMode(EcoCharacteristics ecoCharacteristics) {
        this.neutralRpmRange = new RpmRange(ecoCharacteristics.getReduceGearWhileAccelerating(),
                                            ecoCharacteristics.getRiseGearWhileAccelerating());
    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (neutralRpmRange.isRpmAboveRange(currentRpm)) {
            return GearAction.riseGear();
        } else if (neutralRpmRange.isRpmBelowRange(currentRpm)) {
            return GearAction.reduce();
        }

        return GearAction.nothing();
    }
}
