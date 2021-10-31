package dev.upgrade;

import dev.upgrade.acl.ComportCharacteristics;
import lombok.Data;

@Data
public class ComfortMode implements GearboxMode {
    private final ComportCharacteristics characteristics;

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (currentRpm.isGreaterThan(characteristics.getRiseGearWhileAccelerating())) {
            return GearAction.riseGear();
        } else if (currentRpm.isLowerThan(characteristics.getReduceGearWhileAccelerating())) {
            return GearAction.reduce();
        }

        return GearAction.nothing();
    }
}
