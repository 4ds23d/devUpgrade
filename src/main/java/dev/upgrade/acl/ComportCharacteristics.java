package dev.upgrade.acl;

import dev.upgrade.Rpm;
import dev.upgrade.Threshold;
import lombok.Data;

@Data
public class ComportCharacteristics {
    private final Rpm riseGearWhileAccelerating;
    private final Threshold thresholdSoThatIsNoKickdown;
    private final Rpm reduceGearWhileAccelerating;
    private final Rpm reduceGearWhileKickdown;
    private final Rpm reduceGearWhileBreaking;


    /*
    2 - tryb COMFORT - rpm czy redukować bieg przy przyspieszaniu
3 - tryb COMFORT - threshold naciśnięcia pedału gazu, żeby jeszcze to nie był kickdown
4 - tryb COMFORT - rpm czy podbić bieg przy przyspieszaniu
5 - tryb COMFORT - rpm czy zrzucić bieg w kickdown
     */
}
