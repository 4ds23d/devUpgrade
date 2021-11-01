package dev.upgrade;

import dev.upgrade.acl.ExternalSystemAcl;
import dev.upgrade.acl.GearboxAcl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GearboxDriver {
    private final ExternalSystemAcl externalSystem;
    private final GearboxAcl gearbox;
    private final GearboxModeFactory modeFactory;

    private GearboxMode gearboxMode;

    public GearboxDriver(ExternalSystemAcl externalSystem, GearboxAcl gearbox, GearboxModeFactory modeFactory) {
        this.externalSystem = externalSystem;
        this.gearbox = gearbox;
        this.modeFactory = modeFactory;

        changeToEcoMode();
    }

    void changeToSportMode() {
        gearboxMode = modeFactory.buildGearbox(GearboxModeFactory.Mode.SPORT);
    }

    void changeToEcoMode() {
        gearboxMode = modeFactory.buildGearbox(GearboxModeFactory.Mode.ECO);
    }

    void changeToComfort() {
        gearboxMode = modeFactory.buildGearbox(GearboxModeFactory.Mode.COMFORT);
    }

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
