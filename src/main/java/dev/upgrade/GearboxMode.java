package dev.upgrade;

public interface GearboxMode {
    GearAction handleNewRpm(Rpm currentRpm, Threshold threshold);
}
