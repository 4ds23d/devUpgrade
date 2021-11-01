package dev.upgrade;

import dev.upgrade.acl.Characteristics;
import lombok.Data;

@Data
public class GearboxModeFactory {
    private final Characteristics characteristics;
    enum Mode {
        ECO,
        COMFORT,
        SPORT
    };

    GearboxMode buildGearbox(Mode mode) {
        switch (mode) {
            case ECO:
                return new EcoMode(characteristics.getEcoCharacteristics());
            case COMFORT:
                return new ComfortMode(characteristics.getComportCharacteristics());
            case SPORT:
                return new SportMode(characteristics.getSportCharacteristics());
        }
        throw new UnsupportedOperationException(String.format("Unsupported mode %s", mode));
    }
}
