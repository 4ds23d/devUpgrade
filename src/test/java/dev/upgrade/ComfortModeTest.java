package dev.upgrade;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import dev.upgrade.acl.Characteristics;

import static org.assertj.core.api.Assertions.assertThat;

class ComfortModeTest {

    GearboxMode mode;

    @BeforeEach
    void setUp() {
        var factory = new GearboxModeFactory(new Characteristics());
        this.mode = factory.buildGearbox(GearboxModeFactory.Mode.COMFORT);
    }

    private static Stream<Arguments> dataNewRpm() {
        return Stream.of(
                Arguments.of(new Rpm(2501), new Threshold(0), GearAction.riseGear()),
                Arguments.of(new Rpm(2499), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1001), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(999), new Threshold(0), GearAction.reduce()),
                Arguments.of(new Rpm(11000), new Threshold(0), GearAction.riseGear()),
                Arguments.of(new Rpm(0), new Threshold(0), GearAction.reduce()),

                Arguments.of(new Rpm(1001), new Threshold(0.51), GearAction.reduce()),
                Arguments.of(new Rpm(1001), new Threshold(1), GearAction.reduce()),
                Arguments.of(new Rpm(1001), new Threshold(0.49), GearAction.nothing())
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
