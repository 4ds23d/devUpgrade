package dev.upgrade;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import dev.upgrade.acl.Characteristics;

import static org.assertj.core.api.Assertions.assertThat;

class SportModeTest {
    GearboxModeFactory factory = new GearboxModeFactory(new Characteristics());

    private static Stream<Arguments> dataNewRpmLvl1() {
        return Stream.of(
                Arguments.of(new Rpm(5001), new Threshold(0), GearAction.riseGear()),
                Arguments.of(new Rpm(4999), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(3000), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1501), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1499), new Threshold(0), GearAction.reduce()),
                Arguments.of(new Rpm(0), new Threshold(0), GearAction.reduce()),

                Arguments.of(new Rpm(3000), new Threshold(0.49), GearAction.nothing()),
                Arguments.of(new Rpm(3000), new Threshold(0.51), GearAction.reduce()),
                Arguments.of(new Rpm(3000), new Threshold(0.69), GearAction.reduce()),
                Arguments.of(new Rpm(3000), new Threshold(0.71), GearAction.doubleReduce()),
                Arguments.of(new Rpm(3000), new Threshold(0.9), GearAction.doubleReduce())
        );
    }

    @ParameterizedTest
    @MethodSource("dataNewRpmLvl1")
    @DisplayName("newRpm lvl1")
    void newRpmLvl1(Rpm rpm, Threshold threshold, GearAction expectedAction) {
        // given
        var mode = factory.buildGearbox(GearboxModeFactory.Mode.SPORT, GearboxModeFactory.AggressiveMode.LV1);

        // when
        var action = mode.handleNewRpm(rpm, threshold);

        // then
        assertThat(action).isEqualTo(expectedAction);
    }

    private static Stream<Arguments> dataNewRpmLvl2() {
        return Stream.of(
                Arguments.of(new Rpm(6501), new Threshold(0), GearAction.riseGear()),
                Arguments.of(new Rpm(6500), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(3900), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1950), new Threshold(0), GearAction.nothing()),
                Arguments.of(new Rpm(1949), new Threshold(0), GearAction.reduce()),
                Arguments.of(new Rpm(0), new Threshold(0), GearAction.reduce()),

                Arguments.of(new Rpm(3900), new Threshold(0.49), GearAction.nothing()),
                Arguments.of(new Rpm(3900), new Threshold(0.51), GearAction.reduce()),
                Arguments.of(new Rpm(3900), new Threshold(0.69), GearAction.reduce()),
                Arguments.of(new Rpm(3900), new Threshold(0.71), GearAction.doubleReduce()),
                Arguments.of(new Rpm(3900), new Threshold(0.9), GearAction.doubleReduce())
        );
    }

    @ParameterizedTest
    @MethodSource("dataNewRpmLvl2")
    @DisplayName("newRpm lvl2")
    void newRpmLvl2(Rpm rpm, Threshold threshold, GearAction expectedAction) {
        // given
        var mode = factory.buildGearbox(GearboxModeFactory.Mode.SPORT, GearboxModeFactory.AggressiveMode.LV2);

        // when
        var action = mode.handleNewRpm(rpm, threshold);

        // then
        assertThat(action).isEqualTo(expectedAction);
    }

}
