package dev.upgrade.gearbox;

public class RpmRange {
    private Rpm low;
    private Rpm high;

    public RpmRange(Rpm low, Rpm high) {
        if (low.isGreaterThan(high)) {
            throw new IllegalArgumentException();
        }

        this.low = low;
        this.high = high;
    }

    boolean isRpmBelowRange(Rpm rpm) {
        return rpm.isLowerThan(low);
    }

    boolean isRpmAboveRange(Rpm rpm) {
        return rpm.isGreaterThan(high);
    }

    boolean isInRange(Rpm rpm) {
        return !isRpmBelowRange(rpm) && !isRpmAboveRange(rpm);
    }
}
