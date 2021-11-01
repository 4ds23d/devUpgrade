package dev.upgrade.acl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.upgrade.Rpm;
import dev.upgrade.RpmFactor;
import dev.upgrade.Threshold;

import static org.assertj.core.api.Assertions.assertThat;

class SportCharacteristicsTest {

    @Test
    @DisplayName("multiply by factor")
    void multiplyByFactor() {
        // given
        var sportCharacteristics = new SportCharacteristics(new Rpm(1), new Threshold(2), new Rpm(3), new Threshold(4), new Rpm(5), new Rpm(6), new Rpm(7));
        var factor = new RpmFactor(4);

        // when
        var newCharacteristics = sportCharacteristics.multiplyByFactor(factor);

        // then
        assertThat(newCharacteristics).isEqualTo(new SportCharacteristics(new Rpm(1 * 4), new Threshold(2), new Rpm(3 * 4), new Threshold(4), new Rpm(5 * 4), new Rpm(6 * 4), new Rpm(7 * 4)));
    }
}
