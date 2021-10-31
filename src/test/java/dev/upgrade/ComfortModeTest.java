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

    ComfortMode mode;

    @BeforeEach
    void setUp() {
        var characteristics = new Characteristics();
        this.mode = new ComfortMode(characteristics.getComportCharacteristics());
    }

    private static Stream<Arguments> dataNewRpm() {
        return Stream.of(
                Arguments.of(new Rpm(2501), GearAction.riseGear()),
                Arguments.of(new Rpm(2499), GearAction.nothing()),
                Arguments.of(new Rpm(1001), GearAction.nothing()),
                Arguments.of(new Rpm(999), GearAction.reduce()),
                Arguments.of(new Rpm(11000), GearAction.riseGear()),
                Arguments.of(new Rpm(0), GearAction.reduce())
        );
    }

    @ParameterizedTest
    @MethodSource("dataNewRpm")
    @DisplayName("newRpm")
    void newRpm(Rpm rpm, GearAction expectedAction) {
        // when
        var action = mode.newRpm(rpm);

        // then
        assertThat(action).isEqualTo(expectedAction);
    }
}
