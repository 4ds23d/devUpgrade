package dev.upgrade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.upgrade.acl.GearboxAcl;

import static org.mockito.Mockito.*;

class GearActionTest {

    GearboxAcl gearboxAcl;

    @BeforeEach
    void setUp() {
        gearboxAcl = mock(GearboxAcl.class);
    }

    @Test
    @DisplayName("reduce action")
    void reduceAction() {
        // given
        var action = GearAction.reduce();

        // when
        action.apply(gearboxAcl);

        // then
        verify(gearboxAcl, times(1)).reduceGear();
        verifyNoMoreInteractions(gearboxAcl);
    }

    @Test
    @DisplayName("rise gear")
    void riseGear() {
        // given
        var action = GearAction.riseGear();

        // when
        action.apply(gearboxAcl);

        // then
        verify(gearboxAcl, times(1)).riseGear();
        verifyNoMoreInteractions(gearboxAcl);
    }

    @Test
    @DisplayName("reduce twice")
    void reduceTwice() {
        // given
        var action = GearAction.doubleReduce();

        // when
        action.apply(gearboxAcl);

        // then
        verify(gearboxAcl, times(2)).reduceGear();
        verifyNoMoreInteractions(gearboxAcl);
    }
}
