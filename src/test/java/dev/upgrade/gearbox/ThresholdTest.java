package dev.upgrade.gearbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ThresholdTest {

    @Test
    @DisplayName("accept only legal params")
    void acceptOnlyLegalParams() {
        assertThatThrownBy(() -> new Threshold(-1));

        assertThatCode(() -> new Threshold(0))
                .doesNotThrowAnyException();

        assertThatCode(() -> new Threshold(1.2))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("100 is greater than 99")
    void isGreaterThanA() {
        // given
        var rpm = new Threshold(100);

        // when& then
        assertThat(rpm.isGreaterThan(new Threshold(99))).isTrue();
    }

    @Test
    @DisplayName("99 is not greater than 100")
    void isGreaterThanB() {
        // given
        var rpm = new Threshold(99);

        // when& then
        assertThat(rpm.isGreaterThan(new Threshold(100))).isFalse();
    }

}
