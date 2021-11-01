package dev.upgrade.gearbox;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class KickdownTest {

    private static Stream<Arguments> dataKickdown() {
        return Stream.of(
                Arguments.of(new Threshold(0.5), new Threshold(0.6), true),
                Arguments.of(new Threshold(0.5), new Threshold(0.51), true),
                Arguments.of(new Threshold(0.5), new Threshold(0.49), false),
                Arguments.of(new Threshold(0.5), new Threshold(0.2), false),
                Arguments.of(new Threshold(0.5), new Threshold(0.5), false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataKickdown")
    @DisplayName("isKickdown")
    void isKickdown(Threshold kickdownThreshold, Threshold threshold, Boolean expected) {
        // given
        var kickdown = new Kickdown(kickdownThreshold);

        // when
        var isKickdown = kickdown.isKickdown(threshold);

        // then
        assertThat(isKickdown).isEqualTo(expected);
    }
}
