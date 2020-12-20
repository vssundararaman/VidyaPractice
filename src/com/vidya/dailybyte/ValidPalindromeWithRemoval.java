package com.vidya.dailybyte;

/**
 * This question is asked by Facebook. Given a string and the ability to delete at most one character, return whether or not it can form a palindrome.
 * Note: a palindrome is a sequence of characters that reads the same forwards and backwards.
 * <p>
 * Ex: Given the following strings...
 * <p>
 * "abcba", return true
 * "foobof", return true (remove the first 'o', the second 'o', or 'b')
 * "abccab", return false
 */
public class ValidPalindromeWithRemoval {

    public static void main(String[] args) {

        String str = "abcba";
        System.out.println(isValidPalindrome(str));
        str = "foobof";
        System.out.println(isValidPalindrome(str));
        str = "abccab";
        System.out.println(isValidPalindrome(str));

    }

    static boolean isValidPalindrome(String input) {

        if (input == null || input.length() == 0) {
            return false;
        }
        int i = 0, j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return isValid(input, i + 1, j) || isValid(input, i, j - 1);
            }
            i++;
            j--;
        }


        return true;
    }

    static boolean isValid(String str, int left, int right) {

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

