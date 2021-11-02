package dev.upgrade.gearbox;

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
    @DisplayName("do nothing")
    void doNothing() {
        // given
        var action = GearAction.nothing();

        // when
        action.apply(gearboxAcl);

        // then
        verifyNoMoreInteractions(gearboxAcl);
    }

    @Test
    @DisplayName("increase gear")
    void increaseGear() {
        // given
        var action = GearAction.increaseGear();

        // when
        action.apply(gearboxAcl);

        // then
        verify(gearboxAcl, times(1)).increaseGear();
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
