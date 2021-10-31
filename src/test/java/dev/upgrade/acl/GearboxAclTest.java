package dev.upgrade.acl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GearboxAclTest {
    Gearbox gearbox;

    @BeforeEach
    void setUp() {
        gearbox = mock(Gearbox.class);
    }

    @Test
    @DisplayName("should reduce gear")
    void shouldReduceGear() {
        // given
        when(gearbox.getState()).thenReturn(1);
        when(gearbox.getCurrentGear()).thenReturn(2);
        var gearboxAcl = withGearboxAcl();

        // when
        gearboxAcl.downGear();

        // then
        verify(gearbox, times(1)).setCurrentGear(1);
    }

    @Test
    @DisplayName("should not reduce gear")
    void shouldNotReduceGear() {
        // given
        when(gearbox.getState()).thenReturn(1);
        when(gearbox.getCurrentGear()).thenReturn(1);
        var gearboxAcl = withGearboxAcl();

        // when
        gearboxAcl.downGear();

        // then
        verify(gearbox, times(0)).setCurrentGear(anyInt());
    }

    @Test
    @DisplayName("should rise gear")
    void shouldRiseGear() {
        // given
        when(gearbox.getState()).thenReturn(1);
        when(gearbox.getCurrentGear()).thenReturn(1);
        when(gearbox.getMaxDrive()).thenReturn(3);
        var gearboxAcl = withGearboxAcl();

        // when
        gearboxAcl.upGear();

        // then
        verify(gearbox, times(1)).setCurrentGear(2);
    }

    @Test
    @DisplayName("should not rise a gear")
    void shouldNotRiseAGear() {
        // given
        when(gearbox.getState()).thenReturn(1);
        when(gearbox.getCurrentGear()).thenReturn(3);
        when(gearbox.getMaxDrive()).thenReturn(3);
        var gearboxAcl = withGearboxAcl();

        // when
        gearboxAcl.upGear();

        // then
        verify(gearbox, times(0)).setCurrentGear(anyInt());
    }

    private GearboxAcl withGearboxAcl() {
        return new GearboxAcl(gearbox);
    }
}
