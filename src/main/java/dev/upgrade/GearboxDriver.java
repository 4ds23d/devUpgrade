package dev.upgrade;

import dev.upgrade.acl.ExternalSystemAcl;
import dev.upgrade.acl.GearboxAcl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GearboxDriver {
    private final ExternalSystemAcl externalSystem;
    private final GearboxAcl gearbox;

    void handleGas(Rpm rpm) {

    }
}
