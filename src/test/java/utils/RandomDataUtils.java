package utils;

import tests.TestBase;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDataUtils extends TestBase {
    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("%s%s%s%s", getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }
    public static String getRandomPetType() {
        String[] genders = {"bird", "lizard", "snake", "cat", "dog", "hamster"};

        return getRandomItemFromArray(genders);
    }
    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
}
