package dev.upgrade;

import dev.upgrade.acl.EcoCharacteristics;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class EcoMode implements GearboxMode {
    private final EcoCharacteristics ecoCharacteristics;

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (currentRpm.isGreaterThan(ecoCharacteristics.getRiseGearWhileAccelerating())) {
            return GearAction.riseGear();
        } else if (currentRpm.isLowerThan(ecoCharacteristics.getReduceGearWhileAccelerating())) {
            return GearAction.reduce();
        }

        return GearAction.nothing();
    }
}
