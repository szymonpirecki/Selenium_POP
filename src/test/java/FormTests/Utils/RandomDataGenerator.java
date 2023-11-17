package FormTests.Utils;

import java.util.Random;

public class RandomDataGenerator {

    public static final String[] sex = {"male", "female", "other"};
    public static final String[] continents = {"australia", "south-america", "north-america", "antarctica", "africa", "europe", "asia"};
    public static final String[] professions = {"manual tester", "automation tester", "other"};


    private static final Random random = new Random();

    public static int getRandomExp() {
        return (random.nextInt(7) + 1);
    }

    public static String getRandomOption(String[] options) {
        return options[random.nextInt(options.length)];
    }
}
