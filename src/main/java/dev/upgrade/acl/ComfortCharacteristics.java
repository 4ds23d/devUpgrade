package dev.upgrade.acl;

import dev.upgrade.Rpm;
import dev.upgrade.RpmFactor;
import dev.upgrade.Threshold;
import lombok.AccessLevel;
import lombok.Data;
import lombok.With;

@Data
@With(value = AccessLevel.PRIVATE)
public class ComfortCharacteristics {
    private final Rpm reduceGearWhileAccelerating;
    private final Threshold thresholdSoThatIsNoKickdown;
    private final Rpm riseGearWhileAccelerating;
    private final Rpm reduceGearWhileKickdown;
    private final Rpm reduceGearWhileBreaking;

    public ComfortCharacteristics multiplyByFactor(RpmFactor rpmFactor) {
        return withReduceGearWhileAccelerating(reduceGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withRiseGearWhileAccelerating(riseGearWhileAccelerating.multiplyByFactor(rpmFactor))
                .withReduceGearWhileKickdown(reduceGearWhileKickdown.multiplyByFactor(rpmFactor))
                .withReduceGearWhileBreaking(reduceGearWhileBreaking.multiplyByFactor(rpmFactor));
    }
}
