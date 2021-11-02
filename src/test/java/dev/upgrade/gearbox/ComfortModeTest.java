package dev.upgrade.gearbox;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import dev.upgrade.characteristics.Characteristics;
import dev.upgrade.shared.Rpm;
import dev.upgrade.shared.Threshold;

import static org.assertj.core.api.Assertions.assertThat;

class ComfortModeTest {

    private GearboxModeFactory factory;

    @BeforeEach
    void setUp() {
        factory = new GearboxModeFactory(new Characteristics());
    }

    private static Stream<Arguments> dataNewRpmLvl1() {
        return Stream.of(
                Arguments.of(new Rpm(2501), new Threshold(0), GearAction.increaseGear()),
                Arguments.of(new Rpm(2499), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1001), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(999), new Threshold(0), GearAction.reduce()),
                Arguments.of(new Rpm(11000), new Threshold(0), GearAction.increaseGear()),
                Arguments.of(new Rpm(0), new Threshold(0), GearAction.reduce()),

                Arguments.of(new Rpm(1001), new Threshold(0.51), GearAction.reduce()),
                Arguments.of(new Rpm(1001), new Threshold(1), GearAction.reduce()),
                Arguments.of(new Rpm(1001), new Threshold(0.49), GearAction.nothing())
        );
    }

    private static Stream<Arguments> dataNewRpmLvl2() {
        return Stream.of(
                Arguments.of(new Rpm(3251), new Threshold(0), GearAction.increaseGear()),
                Arguments.of(new Rpm(3250), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1300), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1299), new Threshold(0), GearAction.reduce()),

                Arguments.of(new Rpm(1001), new Threshold(0.51), GearAction.reduce()),
                Arguments.of(new Rpm(1001), new Threshold(1), GearAction.reduce()),
                Arguments.of(new Rpm(1301), new Threshold(0.49), GearAction.nothing())
        );
    }

    @ParameterizedTest
    @MethodSource("dataNewRpmLvl2")
    @DisplayName("newRpm lvl2")
    void newRpmLvl2(Rpm rpm, Threshold threshold, GearAction expectedAction) {
        // given
        var mode = factory.buildGearbox(GearboxModeFactory.Mode.COMFORT, GearboxModeFactory.AggressiveMode.LV2);

        // when
        var action = mode.handleNewRpm(rpm, threshold);

        // then
        assertThat(action).isEqualTo(expectedAction);
    }

    @ParameterizedTest
    @MethodSource("dataNewRpmLvl1")
    @DisplayName("newRpm lvl1")
    void newRpm(Rpm rpm, Threshold threshold, GearAction expectedAction) {
        // given
        var mode = factory.buildGearbox(GearboxModeFactory.Mode.COMFORT, GearboxModeFactory.AggressiveMode.LV1);

        // when
        var action = mode.handleNewRpm(rpm, threshold);

        // then
        assertThat(action).isEqualTo(expectedAction);
    }
}
