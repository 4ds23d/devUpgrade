package dev.upgrade.gearbox;

import java.util.List;

import dev.upgrade.acl.GearboxAcl;
import lombok.Data;

@Data
class GearAction {
    private final List<Type> actions;
    enum Type {
        INCREASE_GEAR,
        REDUCE_GEAR
    }

    void apply(GearboxAcl gearboxAcl) {
        actions.forEach(action -> {
            switch (action) {
                case INCREASE_GEAR:
                    gearboxAcl.increaseGear();
                    break;
                case REDUCE_GEAR:
                    gearboxAcl.reduceGear();
                    break;
            }
        });
    }

    static GearAction doubleReduce() {
        return new GearAction(List.of(Type.REDUCE_GEAR, Type.REDUCE_GEAR));
    }

    static GearAction reduce() {
        return new GearAction(List.of(Type.REDUCE_GEAR));
    }

    static GearAction increaseGear() {
        return new GearAction(List.of(Type.INCREASE_GEAR));
    }

    static GearAction nothing() {
        return new GearAction(List.of());
    }
}
