package dev.upgrade.gearbox;

import java.util.List;

import dev.upgrade.acl.GearboxAcl;
import lombok.Data;

@Data
class GearAction {
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

    static GearAction doubleReduce() {
        return new GearAction(List.of(Type.REDUCE, Type.REDUCE));
    }

    static GearAction reduce() {
        return new GearAction(List.of(Type.REDUCE));
    }

    static GearAction riseGear() {
        return new GearAction(List.of(Type.RISE));
    }

    static GearAction nothing() {
        return new GearAction(List.of());
    }
}
