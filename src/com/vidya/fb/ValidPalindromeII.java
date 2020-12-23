package com.vidya.fb;

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
public class ValidPalindromeII {

    public static void main(String[] args) {

        String str = "abcba";
        System.out.println(isValidPalindrome(str));

        str = "foobof";
        System.out.println(isValidPalindrome(str));

        str = "abccab";
        System.out.println(isValidPalindrome(str));
    }

    static boolean isValidPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {

            if (str.charAt(i) != str.charAt(j)) {
                return isValid(str, i + 1, j) || isValid(str, i, j - 1);
            }

            i++;
            j--;
        }

        return true;
    }

    static boolean isValid(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

