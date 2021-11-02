package dev.upgrade.characteristics;

import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.RpmFactor;
import dev.upgrade.shared.Threshold;
import lombok.AccessLevel;
import lombok.Data;
import lombok.With;

@Data
@With(value = AccessLevel.PRIVATE)
public class ComfortCharacteristics {
    private final Rpm reduceGearWhileAccelerating;
    private final Threshold thresholdSoThatIsNoKickdown;
    private final Rpm increaseGearWhileAccelerating;
    private final Rpm reduceGearWhileKickdown;
    private final Rpm reduceGearWhileBreaking;

    public ComfortCharacteristics multiplyByFactor(RpmFactor rpmFactor) {
        return withReduceGearWhileAccelerating(reduceGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withIncreaseGearWhileAccelerating(increaseGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withReduceGearWhileKickdown(reduceGearWhileKickdown.multiplyByFactor(rpmFactor))
                .withReduceGearWhileBreaking(reduceGearWhileBreaking.multiplyByFactor(rpmFactor));
    }
}
