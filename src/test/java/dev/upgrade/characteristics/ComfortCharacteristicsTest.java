package dev.upgrade.characteristics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.RpmFactor;
import dev.upgrade.shared.Threshold;

import static org.assertj.core.api.Assertions.assertThat;

class ComfortCharacteristicsTest {

    @Test
    @DisplayName("multiply by factor")
    void multiplyByFactor() {
        // given
        var comfort = new ComfortCharacteristics(new Rpm(1), new Threshold(2), new Rpm(3), new Rpm(4), new Rpm(5));
        var factor = new RpmFactor(3);

        // when
        var newComfort = comfort.multiplyByFactor(factor);

        // then
        assertThat(newComfort).isEqualTo(new ComfortCharacteristics(new Rpm(3), new Threshold(2), new Rpm(3 * 3), new Rpm(4 * 3), new Rpm(5 * 3)));
    }
}
