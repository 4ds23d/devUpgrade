package dev.upgrade.acl;

import lombok.Data;

@Data
public class GearboxAcl {
    private final Gearbox gearbox;

    enum State {
        DRIVE,
        PARK,
        REVERSE,
        NEUTRAL

    }
    private State getState() {
        var val = (Integer) gearbox.getState();
        switch (val) {
            case 1:
                return State.DRIVE;
            case 2:
                return State.PARK;
            case 3:
                return State.REVERSE;
            case 4:
                return State.NEUTRAL;
            default:
                throw new IllegalArgumentException(String.format("Illegal state value exception %d", val));
        }
    }

    void downGear() {
        if (getState() != State.DRIVE) {
            return;
        }

        var currentGear = (Integer) gearbox.getCurrentGear();
        if (currentGear > 0) {
            gearbox.setCurrentGear(currentGear - 1);
        }
    }

    void upGear() {
        if (getState() != State.DRIVE) {
            return;
        }

        var currentGear = (Integer) gearbox.getCurrentGear();
        var maxGear = (Integer) gearbox.getMaxDrive();

        if (currentGear < maxGear) {
            gearbox.setCurrentGear(currentGear + 1);
        }
    }
}
