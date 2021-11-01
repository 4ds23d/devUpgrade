package dev.upgrade;

import lombok.Data;

@Data
public
class RpmFactor {
    private final double factor;

    public RpmFactor(double factor) {
        if (factor <= 0.0) {
            throw new IllegalArgumentException(String.format("Illegal factor %f", factor));
        }
        this.factor = factor;
    }
}
