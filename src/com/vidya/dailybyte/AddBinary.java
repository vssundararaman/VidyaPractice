package com.vidya.dailybyte;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public static void main(String[] args) {
        String str1 = "1010", str2 = "1011";

        System.out.println(addBinary(str1, str2));

    }

    static String addBinary(String string1, String string2) {

        StringBuilder stringBuilder = new StringBuilder();

        if (string1 == null || string1.length() == 0 || string2 == null || string2.length() == 0) {
            return stringBuilder.toString();
        }

        int i = string1.length() - 1;
        int j = string2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += string1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += string2.charAt(j) - '0';
                j--;
            }

            stringBuilder.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            stringBuilder.insert(0, 1);
        }

        return stringBuilder.toString();
    }
}
