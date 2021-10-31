package dev.upgrade;

import dev.upgrade.acl.SportCharacteristics;
import lombok.Data;

@Data
public class SportMode implements GearboxMode {
    private final SportCharacteristics sportCharacteristics;

    @Override
    public void changedCurrentRpm(Rpm currentRpm) {

    }
}
