package ru.moneyhoney.playground.util;

import java.util.Random;

public class Rand {

    /* Wrapper class around java.util.Random() */

    static Random random = new Random();
    static String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    public static int Int(int max){
        return random.nextInt(max);
    }

    public static int IntRange(int min, int max){
        return random.nextInt(max) + min;
    }

    public static double Double(int max){
        return random.nextDouble() * max;
    }

    public static double DoubleRange(int min, int max){
        return min + (random.nextDouble() * (max - min));
    }

    public static boolean Bool(){
        int r = Rand.IntRange(0, 100);
        if (r <= 50) return true;
        else return false;
    }

    public static boolean Bool(int chance, int max){
        int r = random.nextInt(max);
        if (r <= chance) return true;
        else return false;
    }

    public static String String(int length) {
        String randomString = "";
        for (int i = 0; i < length; i++ ) {
            if (Bool(50, 100)) {
                if (Bool(50, 100)) { randomString += alphabet[random.nextInt(alphabet.length)]; }
                else { randomString += alphabet[random.nextInt(alphabet.length)].toUpperCase(); }
            }
            else {
                randomString += numbers[random.nextInt(numbers.length)];
            }
        }
        return randomString;
    }

    public static String StringLetters(int length)
    {
        String randomString = "";
        for (int i = 0; i < length; i++)
        {
            if (Bool(50, 100))
            {
                if (Bool(50, 100)) { randomString += alphabet[random.nextInt(alphabet.length)]; }
                else { randomString += alphabet[random.nextInt(alphabet.length)].toUpperCase(); }
            }
        }
        return randomString;
    }

    public static String StringNumbers(int length)
    {
        String randomString = "";
        for (int i = 0; i < length; i++)
        {
            randomString += numbers[random.nextInt(numbers.length)];
        }
        return randomString;
    }

}
