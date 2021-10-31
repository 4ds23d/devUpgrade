package dev.upgrade;

public class Rpm {
    private final double value;

    public Rpm(double value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("Illegal rpm value %d", value));
        }
        this.value = value;
    }
}
