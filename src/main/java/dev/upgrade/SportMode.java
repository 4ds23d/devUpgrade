package dev.upgrade;

import dev.upgrade.acl.SportCharacteristics;
import lombok.Data;

@Data
public class SportMode implements GearboxMode {
    private final SportCharacteristics characteristics;

    @Override
    public GearAction newRpm(Rpm currentRpm) {
        if (currentRpm.isGreaterThan(characteristics.getRiseGearWhileAccelerating())) {
            return GearAction.riseGear();
        } else if (currentRpm.isLowerThan(characteristics.getReduceGearWhileSlowlyAccelerating())) {
            return GearAction.reduce();
        }

        return GearAction.nothing();
    }
}
