package dev.upgrade;

import java.util.List;

public interface GearboxMode {
    GearAction handleNewRpm(Rpm currentRpm);
}
