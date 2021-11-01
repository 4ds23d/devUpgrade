package dev.upgrade;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import dev.upgrade.acl.Characteristics;

import static org.assertj.core.api.Assertions.assertThat;

class EcoModeTest {
    private GearboxModeFactory factory = new GearboxModeFactory(new Characteristics());

    private static Stream<Arguments> dataNewRpmLvl1() {
        return Stream.of(
                Arguments.of(new Rpm(2001), GearAction.riseGear()),
                Arguments.of(new Rpm(1999), GearAction.nothing()),
                Arguments.of(new Rpm(1001), GearAction.nothing()),
                Arguments.of(new Rpm(999), GearAction.reduce()),
                Arguments.of(new Rpm(11000), GearAction.riseGear()),
                Arguments.of(new Rpm(0), GearAction.reduce())
        );
    }

    @ParameterizedTest
    @MethodSource("dataNewRpmLvl1")
    @DisplayName("newRpm lvl1")
    void newRpmLvl1(Rpm rpm, GearAction expectedAction) {
        // given
        var mode = factory.buildGearbox(GearboxModeFactory.Mode.ECO, GearboxModeFactory.AggressiveMode.LV1);

        // when
        var action = mode.handleNewRpm(rpm, new Threshold(0));

        // then
        assertThat(action).isEqualTo(expectedAction);
    }

    private static Stream<Arguments> dataNewRpmLvl2() {
        return Stream.of(
                Arguments.of(new Rpm(2601), GearAction.riseGear()),
                Arguments.of(new Rpm(2600), GearAction.nothing()),
                Arguments.of(new Rpm(1300), GearAction.nothing()),
                Arguments.of(new Rpm(1299), GearAction.reduce()),
                Arguments.of(new Rpm(11000), GearAction.riseGear()),
                Arguments.of(new Rpm(0), GearAction.reduce())
        );
    }

    @ParameterizedTest
    @MethodSource("dataNewRpmLvl2")
    @DisplayName("newRpm lvl2")
    void newRpmLvl2(Rpm rpm, GearAction expectedAction) {
        // given
        var mode = factory.buildGearbox(GearboxModeFactory.Mode.ECO, GearboxModeFactory.AggressiveMode.LV2);

        // when
        var action = mode.handleNewRpm(rpm, new Threshold(0));

        // then
        assertThat(action).isEqualTo(expectedAction);
    }
}
