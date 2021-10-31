package dev.upgrade.acl;

import dev.upgrade.Rpm;
import lombok.Data;

@Data
public class ExternalSystemAcl {
    private final ExternalSystems externalSystems;

    public Rpm getCurrentRpm() {
        return new Rpm(externalSystems.getCurrentRpm());
    }
}
