package dev.upgrade;

import dev.upgrade.acl.Characteristics;
import dev.upgrade.acl.ExternalSystemAcl;
import dev.upgrade.acl.GearboxAcl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GearboxDriver {
    private final GearboxModeFactory modeFactory = new GearboxModeFactory(new Characteristics());

    private final ExternalSystemAcl externalSystem;
    private final GearboxAcl gearbox;

    private GearboxModeFactory.Mode mode = GearboxModeFactory.Mode.ECO;
    private GearboxModeFactory.AggressiveMode aggressiveMode = GearboxModeFactory.AggressiveMode.LV1;
    private GearboxMode gearboxMode;

    public GearboxDriver(ExternalSystemAcl externalSystem, GearboxAcl gearbox) {
        this.externalSystem = externalSystem;
        this.gearbox = gearbox;

    }

    void changeToAggressiveModeLv1() {
        aggressiveMode = GearboxModeFactory.AggressiveMode.LV1;
        buildGearboxMode();
    }

    void changeToAggressiveModeLv2() {
        aggressiveMode = GearboxModeFactory.AggressiveMode.LV2;
        buildGearboxMode();
    }

    void changeToAggressiveModeLv3() {
        aggressiveMode = GearboxModeFactory.AggressiveMode.LV3;
        buildGearboxMode();
    }

    void changeToSportMode() {
        mode = GearboxModeFactory.Mode.SPORT;
        buildGearboxMode();
    }

    void changeToEcoMode() {
        mode = GearboxModeFactory.Mode.ECO;
        buildGearboxMode();
    }

    void changeToComfort() {
        mode = GearboxModeFactory.Mode.COMFORT;
        buildGearboxMode();
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

    private void buildGearboxMode() {
        gearboxMode = modeFactory.buildGearbox(mode, aggressiveMode);
    }
}
