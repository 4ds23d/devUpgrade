package dev.upgrade.shared;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@Getter(AccessLevel.NONE)
public class Kickdown {
    private final Threshold kickdownThreshold;

    public boolean isKickdown(Threshold threshold) {
        return threshold.isGreaterThan(kickdownThreshold);
    }
}
