package dev.upgrade.acl;

import dev.upgrade.Rpm;
import dev.upgrade.Threshold;
import lombok.Data;

@Data
public class SportCharacteristics {
    private final Rpm riseGearWhileAccelerating;
    private final Threshold thresholdSlowlyAccelerating;
    private final Rpm reduceGearWhileSlowlyAccelerating;
    private final Threshold thresholdSlowlyKickdown;
    private final Rpm reduceGearWhileSlowlyKickdown;
    private final Rpm reduceGearWhileKickdown;
    private final Rpm reduceGearWhileBreaking;
}
