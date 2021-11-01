package dev.upgrade.gearbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RpmTest {
   @Test
   @DisplayName("accept only legal params")
   void acceptOnlyLegalParams() {
       assertThatThrownBy(() -> new Rpm(-1));

       assertThatCode(() -> new Rpm(0))
               .doesNotThrowAnyException();

       assertThatCode(() -> new Rpm(1.2))
               .doesNotThrowAnyException();
   }

    @Test
    @DisplayName("199 RPM is lower than 200 RPM")
    void isLowerThanA() {
        // given
        var rpm = new Rpm(199);

        // when& then
        assertThat(rpm.isLowerThan(new Rpm(200))).isTrue();
    }

    @Test
    @DisplayName("200 RPM is not lower than 199 RPM")
    void isLowerThanB() {
        // given
        var rpm = new Rpm(200);

        // when& then
        assertThat(rpm.isLowerThan(new Rpm(199))).isFalse();
    }

    @Test
    @DisplayName("100RPM is greater than 99RPM")
    void isGreaterThanA() {
        // given
        var rpm = new Rpm(100);

        // when& then
        assertThat(rpm.isGreaterThan(new Rpm(99))).isTrue();
    }

    @Test
    @DisplayName("99RPM is not greater than 100RPM")
    void isGreaterThanB() {
        // given
        var rpm = new Rpm(99);

        // when& then
        assertThat(rpm.isGreaterThan(new Rpm(100))).isFalse();
    }

    @Test
    @DisplayName("multiply by factor")
    void multiplyByFactor() {
        // given
        var rpmFactor = new RpmFactor(1.5);
        var rpm = new Rpm(2000);

        // when
        var multiplyRpm = rpm.multiplyByFactor(rpmFactor);

        // then
        assertThat(multiplyRpm).isEqualTo(new Rpm(2000 * 1.5));
    }

}
