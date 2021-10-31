package dev.upgrade;

import dev.upgrade.acl.EcoCharacteristics;
import lombok.Data;

@Data
public class EcoMode implements GearboxMode {
    private EcoCharacteristics ecoCharacteristics;

    @Override
    public void changedCurrentRpm(Rpm currentRpm) {

    }
}
