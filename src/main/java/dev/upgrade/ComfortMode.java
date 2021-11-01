package dev.upgrade;

import dev.upgrade.acl.ComportCharacteristics;

public class ComfortMode implements GearboxMode {
    private final Kickdown kickdown;
    private final RpmRange rpmRange;

    public ComfortMode(ComportCharacteristics characteristics) {
        this.rpmRange = new RpmRange(characteristics.getReduceGearWhileAccelerating(), characteristics.getRiseGearWhileAccelerating());
        this.kickdown = new Kickdown(characteristics.getThresholdSoThatIsNoKickdown());
    }

    @Override
    public GearAction handleNewRpm(Rpm currentRpm, Threshold threshold) {
        if (kickdown.isKickdown(threshold)) {
            return GearAction.reduce();
        } else {
            if (rpmRange.isAbove(currentRpm)) {
                return GearAction.riseGear();
            } else if (rpmRange.isBelow(currentRpm)) {
                return GearAction.reduce();
            }
        }

        return GearAction.nothing();
    }
}
