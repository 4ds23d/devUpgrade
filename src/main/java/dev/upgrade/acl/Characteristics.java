package dev.upgrade.acl;

import dev.upgrade.Rpm;
import dev.upgrade.Threshold;

public class Characteristics {
    private Object[] characteristics = new Object[]{2000d, 1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d, 5000d, 5000d, 1500d, 2000d, 3000d, 6500d, 14d};
        /*
            index:
            0 - tryb ECO - rpm czy podbić bieg przy przyspieszaniu
            1 - tryb ECO - rpm czy redukować bieg przy przyspieszaniu
            2 - tryb COMFORT - rpm czy redukować bieg przy przyspieszaniu
            3 - tryb COMFORT - threshold naciśnięcia pedału gazu, żeby jeszcze to nie był kickdown
            4 - tryb COMFORT - rpm czy podbić bieg przy przyspieszaniu
            5 - tryb COMFORT - rpm czy zrzucić bieg w kickdown
            6 - tryb SPORT -  rpm czy zrzucić bieg przy przyspieszaniu
            7 - tryb SPORT -  threshold naciśnięcia pedału gazu, żeby czy lekko przyspieszamy
            8 - tryb SPORT -  rpm czy zwiekszamy bieg w lekkim przyspieszeniu
            9 - tryb SPORT -  threshold naciśnięcia pedału gazu, żeby czy lekki kickdown
            10 - tryb SPORT -  rpm czy redukcja w lekkim kickdown
            11 - tryb SPORT -  rpm czy zrzucić 2 biegi w MOCNYM kickdown - zapier...
            12 - tryb ECO - rpm zrzucić bieg przy hamowaniu
            13 - tryb COMFORT - rpm zrzucić bieg przy hamowaniu
            14 - tryb SPORT - rpm zrzucić bieg przy hamowaniu
            15 - ???
            17 - tryb HIDDEN MODE - kiedy podbić bieg przy przyspieszaniu
            18 - tryb HIDDEN MODE - kiedy redukować bieg przy przyspieszaniu w hidden mode
            19 - tryb HIDDEN MODE - kiedy redukować bieg przy hamowaniu w hidden mode (chyba)
     */

    private final EcoCharacteristics ecoCharacteristics;
    private final ComportCharacteristics comportCharacteristics;
    private final SportCharacteristics sportCharacteristics;

    public Characteristics() {
        ecoCharacteristics = new EcoCharacteristics(
                new Rpm((double) characteristics[0]),
                new Rpm((double) characteristics[1]),
                new Rpm((double) characteristics[12])
        );

        comportCharacteristics = new ComportCharacteristics(
                new Rpm((double) characteristics[2]),
                new Threshold((double) characteristics[3]),
                new Rpm((double) characteristics[4]),
                new Rpm((double) characteristics[5]),
                new Rpm((double) characteristics[13])
        );

        sportCharacteristics = new SportCharacteristics(
                new Rpm((double) characteristics[6]),
                new Threshold((double) characteristics[7]),
                new Rpm((double) characteristics[8]),
                new Threshold((double) characteristics[9]),
                new Rpm((double) characteristics[10]),
                new Rpm((double) characteristics[11]),
                new Rpm((double) characteristics[14])
        );
    }

    public EcoCharacteristics getEcoCharacteristics() {
        return ecoCharacteristics;
    }

    public ComportCharacteristics getComportCharacteristics() {
        return comportCharacteristics;
    }

    public SportCharacteristics getSportCharacteristics() {
        return sportCharacteristics;
    }
}
