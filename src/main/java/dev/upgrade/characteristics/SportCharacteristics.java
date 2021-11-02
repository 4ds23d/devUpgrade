package dev.upgrade.characteristics;

import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.RpmFactor;
import dev.upgrade.shared.Threshold;
import lombok.AccessLevel;
import lombok.Data;
import lombok.With;

@Data
@With(value = AccessLevel.PRIVATE)
public class SportCharacteristics {
    private final Rpm reduceGearWhileSlowlyAccelerating;
    private final Threshold thresholdLightKickdown;
    private final Rpm increaseGearWhileAccelerating;
    private final Threshold thresholdHeavyKickdown;
    private final Rpm reduceGearWhileSlowlyKickdown;
    private final Rpm reduceGearWhileKickdown;
    private final Rpm reduceGearWhileBreaking;

    public SportCharacteristics multiplyByFactor(RpmFactor rpmFactor) {
        return withReduceGearWhileSlowlyAccelerating(reduceGearWhileSlowlyAccelerating.multiplyByFactor(rpmFactor))
                .withIncreaseGearWhileAccelerating(increaseGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withReduceGearWhileSlowlyKickdown(reduceGearWhileSlowlyKickdown.multiplyByFactor(rpmFactor))
                .withReduceGearWhileKickdown(reduceGearWhileKickdown.multiplyByFactor(rpmFactor))
                .withReduceGearWhileBreaking(reduceGearWhileBreaking.multiplyByFactor(rpmFactor));
    }
}
