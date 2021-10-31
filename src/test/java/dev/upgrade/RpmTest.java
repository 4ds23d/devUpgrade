package dev.upgrade;

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

}
