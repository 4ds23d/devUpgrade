package dev.upgrade;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import dev.upgrade.acl.Characteristics;

import static org.assertj.core.api.Assertions.assertThat;

class SportModeTest {

    SportMode mode;

    @BeforeEach
    void setUp() {
        var characteristics = new Characteristics();
        this.mode = new SportMode(characteristics.getSportCharacteristics());
    }

    private static Stream<Arguments> dataNewRpm() {
        return Stream.of(
                Arguments.of(new Rpm(5001), new Threshold(0), GearAction.riseGear()),
                Arguments.of(new Rpm(4999), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(3000), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1501), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1499), new Threshold(0), GearAction.reduce()),
                Arguments.of(new Rpm(0), new Threshold(0), GearAction.reduce())
        );
    }

    @ParameterizedTest
    @MethodSource("dataNewRpm")
    @DisplayName("newRpm")
    void newRpm(Rpm rpm, Threshold threshold, GearAction expectedAction) {
        // when
        var action = mode.handleNewRpm(rpm, threshold);

        // then
        assertThat(action).isEqualTo(expectedAction);
    }

}
