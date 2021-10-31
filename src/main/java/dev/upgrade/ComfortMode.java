package dev.upgrade;

import lombok.Data;

@Data
public class ComfortMode implements GearboxMode {
    private final ComfortMode comfortMode;

    @Override
    public GearAction newRpm(Rpm currentRpm) {
        throw new UnsupportedOperationException("BARKAS TODO    ComfortMode#11 ");
    }
}
