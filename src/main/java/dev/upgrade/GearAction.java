package dev.upgrade;

import java.util.List;

import lombok.Data;

@Data
public class GearAction {
    private final List<Type> actions;
    enum Type {
        RISE,
        REDUCE
    }

    public static GearAction reduce() {
        return new GearAction(List.of(Type.REDUCE));
    }

    public static GearAction riseGear() {
        return new GearAction(List.of(Type.RISE));
    }

    public static GearAction nothing() {
        return new GearAction(List.of());
    }
}
