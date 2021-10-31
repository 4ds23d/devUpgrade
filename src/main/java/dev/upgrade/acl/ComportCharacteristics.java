package dev.upgrade.acl;

import dev.upgrade.Rpm;
import dev.upgrade.Threshold;
import lombok.Data;

@Data
public class ComportCharacteristics {
    private final Rpm reduceGearWhileAccelerating;
    private final Threshold thresholdSoThatIsNoKickdown;
    private final Rpm riseGearWhileAccelerating;
    private final Rpm reduceGearWhileKickdown;
    private final Rpm reduceGearWhileBreaking;
}
