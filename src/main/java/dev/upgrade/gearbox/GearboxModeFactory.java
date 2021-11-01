package dev.upgrade.gearbox;

import dev.upgrade.characteristics.Characteristics;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class GearboxModeFactory {
    private final Characteristics characteristics;

    enum Mode {
        ECO,
        COMFORT,
        SPORT
    }

    enum AggressiveMode {
        LV1,
        LV2,
        LV3
    }

    private RpmFactor getRpmFactor(AggressiveMode aggressiveMode) {
        switch (aggressiveMode) {
            case LV1:
                return new RpmFactor(1.0);
            case LV2:
            case LV3:
                return new RpmFactor(1.3);
        }
        throw new UnsupportedOperationException(String.format("Unsupported aggressive mode %s", aggressiveMode));
    }

    GearboxMode buildGearbox(Mode mode, AggressiveMode aggressiveMode) {
        var rpmFactor = getRpmFactor(aggressiveMode);
        switch (mode) {
            case ECO:
                return new EcoMode(characteristics.getEcoCharacteristics().multiplyByFactor(rpmFactor));
            case COMFORT:
                return new ComfortMode(characteristics.getComportCharacteristics().multiplyByFactor(rpmFactor));
            case SPORT:
                return new SportMode(characteristics.getSportCharacteristics().multiplyByFactor(rpmFactor));
        }
        throw new UnsupportedOperationException(String.format("Unsupported mode %s", mode));
    }
}
