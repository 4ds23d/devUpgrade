package dev.upgrade;

import java.util.List;

public interface GearboxMode {
    GearAction newRpm(Rpm currentRpm);
}
