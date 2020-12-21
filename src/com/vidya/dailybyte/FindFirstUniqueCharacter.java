package com.vidya.dailybyte;

import java.util.HashMap;
import java.util.Map;

/**
 *This question is asked by Microsoft. Given a string, return the index of its first unique character.
 If a unique character does not exist, return -1.
 *
 * Ex: Given the following strings...
 *
 * "abcabd", return 2
 * "thedailybyte", return 1
 * "developer", return 0
 */
public class FindFirstUniqueCharacter {

    public static void main(String[] args) {

        String str = "abcabd";
        System.out.println(findFirstUniqueChar(str));

        str = "thedailybyte";
        System.out.println(findFirstUniqueChar(str));

        str = "developer";
        System.out.println(findFirstUniqueChar(str));
    }

    static int findFirstUniqueChar(String s) {

        Map<Character, Integer> countMap = new HashMap<>();

        int n = s.length();

        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
