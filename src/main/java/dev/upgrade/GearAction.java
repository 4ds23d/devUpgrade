package dev.upgrade;

import java.util.List;

import dev.upgrade.acl.GearboxAcl;
import lombok.Data;

@Data
public class GearAction {
    private final List<Type> actions;
    enum Type {
        RISE,
        REDUCE
    }

    void apply(GearboxAcl gearboxAcl) {
        actions.forEach(action -> {
            switch (action) {
                case RISE:
                    gearboxAcl.riseGear();
                    break;
                case REDUCE:
                    gearboxAcl.reduceGear();
                    break;
            }
        });
    }

    public static GearAction doubleReduce() {
        return new GearAction(List.of(Type.REDUCE, Type.REDUCE));
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
