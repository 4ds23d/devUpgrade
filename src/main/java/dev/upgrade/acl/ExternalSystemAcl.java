package dev.upgrade.acl;

import dev.upgrade.gearbox.Rpm;
import lombok.Data;

@Data
public class ExternalSystemAcl {
    private ExternalSystems externalSystems = new ExternalSystems();

    public Rpm getCurrentRpm() {
        return new Rpm(externalSystems.getCurrentRpm());
    }
}
