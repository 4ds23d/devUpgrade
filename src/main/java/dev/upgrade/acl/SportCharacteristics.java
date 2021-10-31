package dev.upgrade.acl;

import dev.upgrade.Rpm;
import dev.upgrade.Threshold;
import lombok.Data;

@Data
public class SportCharacteristics {
    private final Rpm reduceGearWhileSlowlyAccelerating;
    private final Threshold thresholdLightKickdown;
    private final Rpm riseGearWhileAccelerating;
    private final Threshold thresholdHeavyickdown;
    private final Rpm reduceGearWhileSlowlyKickdown;
    private final Rpm reduceGearWhileKickdown;
    private final Rpm reduceGearWhileBreaking;
}
