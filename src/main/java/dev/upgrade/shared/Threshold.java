package dev.upgrade.shared;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@Getter(AccessLevel.NONE)
public class Threshold {
    private final double threshold;

    public Threshold(double threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException();
        }
        this.threshold = threshold;
    }

    public boolean isGreaterThan(Threshold threshold) {
        return this.threshold > threshold.threshold;
    }
}
