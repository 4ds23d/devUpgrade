package dev.upgrade.gearbox;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

class RpmRangeTest {

    enum Expected {
        IS_ABOVE,
        IS_IN_RANGE,
        IS_BELOW
    }
    private static Stream<Arguments> dataGeneralTest() {
        return Stream.of(
                Arguments.of(new Rpm(1), new Rpm(1.5), new Rpm(2), Expected.IS_IN_RANGE),
                Arguments.of(new Rpm(1), new Rpm(2.1), new Rpm(2), Expected.IS_ABOVE),
                Arguments.of(new Rpm(1), new Rpm(0), new Rpm(2), Expected.IS_BELOW),
                Arguments.of(new Rpm(1), new Rpm(1), new Rpm(2), Expected.IS_IN_RANGE),
                Arguments.of(new Rpm(1), new Rpm(2), new Rpm(2), Expected.IS_IN_RANGE)
        );
    }

    @ParameterizedTest
    @MethodSource("dataGeneralTest")
    @DisplayName("general tests")
    void generalTests(Rpm low, Rpm test, Rpm high, Expected expected) {
        // given
        var range = new RpmRange(low, high);

        // when & then
        switch (expected) {
            case IS_ABOVE:
                assertThat(range.isRpmAboveRange(test)).isTrue();
                assertThat(range.isRpmBelowRange(test)).isFalse();
                assertThat(range.isInRange(test)).isFalse();
                break;
            case IS_BELOW:
                assertThat(range.isRpmAboveRange(test)).isFalse();
                assertThat(range.isRpmBelowRange(test)).isTrue();
                assertThat(range.isInRange(test)).isFalse();
                break;
            case IS_IN_RANGE:
                assertThat(range.isRpmAboveRange(test)).isFalse();
                assertThat(range.isRpmBelowRange(test)).isFalse();
                assertThat(range.isInRange(test)).isTrue();
                break;
        }
    }

    @Test
    @DisplayName("illegal input params")
    void illegalInputParams() {
        // given
        var low = new Rpm(2);
        var high = new Rpm(20);

        // when & then
        assertThatCode(() -> new RpmRange(low, high))
                .doesNotThrowAnyException();

        // but when & then
        assertThatThrownBy(() -> new RpmRange(high, low));
    }
}
