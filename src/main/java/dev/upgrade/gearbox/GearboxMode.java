package dev.upgrade.gearbox;

import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.Threshold;

interface GearboxMode {
    GearAction handleNewRpm(Rpm currentRpm, Threshold threshold);
}
