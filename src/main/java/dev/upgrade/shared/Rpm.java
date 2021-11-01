package dev.upgrade.shared;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@Getter(AccessLevel.NONE)
public class Rpm {
    private final double value;

    public Rpm(double value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("Illegal rpm value %f", value));
        }
        this.value = value;
    }

    public boolean isGreaterThan(Rpm other) {
        return value > other.value;
    }

    public boolean isLowerThan(Rpm other) {
        return value < other.value;
    }

    public Rpm multiplyByFactor(RpmFactor factor) {
        return new Rpm(value * factor.getFactor());
    }
}
