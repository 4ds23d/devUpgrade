package dev.upgrade.characteristics;

import dev.upgrade.gearbox.Rpm;
import dev.upgrade.gearbox.RpmFactor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.With;

@Data
@With(value = AccessLevel.PRIVATE)
public class EcoCharacteristics {
    private final Rpm riseGearWhileAccelerating;
    private final Rpm reduceGearWhileAccelerating;
    private final Rpm reduceGearWhileBreaking;

    public EcoCharacteristics multiplyByFactor(RpmFactor rpmFactor) {
        return withRiseGearWhileAccelerating(riseGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withReduceGearWhileAccelerating(reduceGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withReduceGearWhileBreaking(reduceGearWhileBreaking.multiplyByFactor(rpmFactor));
    }
}
