package dev.upgrade;

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

    boolean isBelow(Rpm rpm) {
        return rpm.isLowerThan(low);
    }

    boolean isAbove(Rpm rpm) {
        return rpm.isGreaterThan(high);
    }

    boolean isInRange(Rpm rpm) {
        return !isBelow(rpm) && !isAbove(rpm);
    }
}
