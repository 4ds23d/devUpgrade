package dev.upgrade.gearbox;

interface GearboxMode {
    GearAction handleNewRpm(Rpm currentRpm, Threshold threshold);
}
