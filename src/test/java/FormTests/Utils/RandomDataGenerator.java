package FormTests.Utils;

import java.util.List;
import java.util.Random;

public class RandomDataGenerator {

    private static final Random random = new Random();

    public static String getRandomOption(List<String> options) {
        return options.get(random.nextInt(options.size()));
    }
}
