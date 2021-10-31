package dev.upgrade.acl;

import dev.upgrade.Rpm;
import lombok.Data;

@Data
public class EcoCharacteristics {
    private final Rpm riseGearWhileAccelerating;
    private final Rpm reduceGearWhileAccelerating;
    private final Rpm reduceGearWhileBreaking;
}
