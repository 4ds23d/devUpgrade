package dev.upgrade;

import dev.upgrade.acl.ExternalSystemAcl;
import dev.upgrade.acl.GearboxAcl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GearboxDriver {
    private final ExternalSystemAcl externalSystem;
    private final GearboxAcl gearbox;
    private final GearboxMode gearboxMode;

    void reduceGear() {
        gearbox.reduceGear();
    }

    void riseGear() {
        gearbox.riseGear();
    }

    void handleGas(Threshold threshold) {
        var currentRpm = externalSystem.getCurrentRpm();
        var actions = gearboxMode.handleNewRpm(currentRpm, threshold);
        actions.apply(gearbox);
    }
}
