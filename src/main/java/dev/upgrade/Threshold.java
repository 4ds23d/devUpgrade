package dev.upgrade;

public class Threshold {
    private final double threshold;

    public Threshold(double threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException();
        }
        this.threshold = threshold;
    }
}
