/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Random;

public class RandomGenerator {

    public static String generateGender() {
        Random r2 = new Random();
        String[] array = {"Male", "Female"};
        String name = array[r2.nextInt(array.length)];
        return name;
    }

    public static boolean getRandomBoolean() {
        Random random2 = new Random();
        return random2.nextBoolean();
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static double randDouble(int min, int max) {
        Random r = new Random();
        double randValue = min + (max - min) * r.nextDouble();
        return randValue;
    }

    ////////////
}
