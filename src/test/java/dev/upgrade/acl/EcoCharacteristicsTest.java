package dev.upgrade.acl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.upgrade.Rpm;
import dev.upgrade.RpmFactor;

import static org.assertj.core.api.Assertions.assertThat;

class EcoCharacteristicsTest {

    @Test
    @DisplayName("multiplyBy")
    void multiplyBy() {
        // given
        var characteristics = new EcoCharacteristics(new Rpm(1), new Rpm(2), new Rpm(3));
        var factor = new RpmFactor(3);

        // when
        var newCharacteristics = characteristics.multiplyByFactor(factor);

        // then
        assertThat(newCharacteristics).isEqualTo(new EcoCharacteristics(new Rpm(1 * 3), new Rpm(2 * 3), new Rpm(3 * 3)));
    }
}
