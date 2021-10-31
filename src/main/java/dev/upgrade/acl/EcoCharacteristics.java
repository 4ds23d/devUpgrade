package dev.upgrade.acl;

import dev.upgrade.Rpm;
import lombok.Data;

@Data
public class EcoCharacteristics {
    private final Rpm riseGearWhileAccelerating;
    private final Rpm reduceGearWhileAccelerating;
    private final Rpm reduceGearWhileBreaking;


    /*

    index:
6 - tryb SPORT -  rpm czy zrzucić bieg przy przyspieszaniu
7 - tryb SPORT -  threshold naciśnięcia pedału gazu, żeby czy lekko przyspieszamy
8 - tryb SPORT -  rpm czy zwiekszamy bieg w lekkim przyspieszeniu
9 - tryb SPORT -  threshold naciśnięcia pedału gazu, żeby czy lekki kickdown
10 - tryb SPORT -  rpm czy redukcja w lekkim kickdown
11 - tryb SPORT -  rpm czy zrzucić 2 biegi w MOCNYM kickdown - zapier...
14 - tryb SPORT - rpm zrzucić bieg przy hamowaniu
15 - ???
17 - tryb HIDDEN MODE - kiedy podbić bieg przy przyspieszaniu
18 - tryb HIDDEN MODE - kiedy redukować bieg przy przyspieszaniu w hidden mode
19 - tryb HIDDEN MODE - kiedy redukować bieg przy hamowaniu w hidden mode (chyba)
     */
}
