package com.vidya.dailybyte;

/**
 * This question is asked by Google. Given a string, return whether or not it uses capitalization correctly. A string correctly uses capitalization if all letters are capitalized, no letters are capitalized, or only the first letter is capitalized.
 *
 * Ex: Given the following strings...
 *
 * "USA", return true
 * "Calvin", return true
 * "compUter", return false
 * "coding", return true
 */
public class CorrectCapitalization {

    public static void main(String[] args) {

        String str = "USA";
        System.out.println(isCorrectCapitalization(str));

        str = "Calvin";
        System.out.println(isCorrectCapitalization(str));

        str = "compUter";
        System.out.println(isCorrectCapitalization(str));

        str = "coding";
        System.out.println(isCorrectCapitalization(str));
    }

    static boolean isCorrectCapitalization(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        int count = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }
        return count == 0 || count == str.length() || count == 1 && Character.isUpperCase(str.charAt(0));
    }
}
