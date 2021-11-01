package dev.upgrade.gearbox;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@Getter(AccessLevel.NONE)
class Kickdown {
    private final Threshold kickdownThreshold;

    boolean isKickdown(Threshold threshold) {
        return threshold.isGreaterThan(kickdownThreshold);
    }
}
