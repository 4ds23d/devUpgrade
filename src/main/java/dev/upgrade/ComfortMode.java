package dev.upgrade;

import dev.upgrade.acl.ComportCharacteristics;
import lombok.Data;

@Data
public class ComfortMode implements GearboxMode {
    private final ComportCharacteristics characteristics;
    private final Kickdown kickdown;

    public ComfortMode(ComportCharacteristics characteristics) {
        this.characteristics = characteristics;
        this.kickdown = new Kickdown(this.characteristics.getThresholdSoThatIsNoKickdown());
    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (kickdown.isKickdown(threshold)) {
            return GearAction.reduce();
        }

        if (currentRpm.isGreaterThan(characteristics.getRiseGearWhileAccelerating())) {
            return GearAction.riseGear();
        } else if (currentRpm.isLowerThan(characteristics.getReduceGearWhileAccelerating())) {
            return GearAction.reduce();
        }

        return GearAction.nothing();
    }
}
