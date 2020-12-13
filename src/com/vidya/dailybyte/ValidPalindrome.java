package com.vidya.dailybyte;

import java.util.Locale;

/**
 * This question is asked by Facebook. Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
 * Note: a palindrome is a sequence of characters that reads the same forwards and backwards.
 *
 * Ex: Given the following strings...
 *
 * "level", return true
 * "algorithm", return false
 * "A man, a plan, a canal: Panama.", return true
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String str = "level";
        System.out.println(isValidPalindrome(str));

        str = "algorithm";
        System.out.println(isValidPalindrome(str));

        str = "A man, a plan, a canal: Panama.";
        System.out.println(isValidPalindrome(str));
    }

    static boolean isValidPalindrome(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        String modified = str.replaceAll("[^A-Za-z]","").toLowerCase(Locale.ROOT);

        String output = "";

        for (int i = 0; i < modified.length(); i++) {

            String odd = isValid(modified, i, i);
            if (odd.length() > output.length()) {
                output = odd;
            }

            String even = isValid(modified, i,i+1);
            if(even.length() > output.length()){
                output = even;
            }
        }

        return modified.equals(output);
    }

    static String isValid(String str, int left, int right) {

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return str.substring(left + 1, right);
    }


}
