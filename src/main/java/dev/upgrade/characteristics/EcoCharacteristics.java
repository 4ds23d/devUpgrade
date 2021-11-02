package dev.upgrade.characteristics;

import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.RpmFactor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.With;

@Data
@With(value = AccessLevel.PRIVATE)
public class EcoCharacteristics {
    private final Rpm increaseGearWhileAccelerating;
    private final Rpm reduceGearWhileAccelerating;
    private final Rpm reduceGearWhileBreaking;

    public EcoCharacteristics multiplyByFactor(RpmFactor rpmFactor) {
        return withIncreaseGearWhileAccelerating(increaseGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withReduceGearWhileAccelerating(reduceGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withReduceGearWhileBreaking(reduceGearWhileBreaking.multiplyByFactor(rpmFactor));
    }
}
