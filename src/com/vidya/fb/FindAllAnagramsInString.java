package com.vidya.fb;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String s = "cbaebabacd", p= "abc";
        System.out.println(findAllAnagrams(s,p));

        s = "abab"; p= "ab";

        System.out.println(findAllAnagrams(s,p));
    }

    static List<Integer> findAllAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        int count = 0;
        int[] charMap = new int[26];

        for (char ch : p.toCharArray()) {
            charMap[ch - 'a']++;
            count++;
        }

        int left = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            charMap[ch - 'a']--;
            count--;

            if (count == 0) {
                if (allZero(charMap)) {
                    result.add(left);
                }

                char lc = s.charAt(left);
                charMap[lc - 'a']++;

                count++;
                left++;
            }
        }
        return result;
    }

    private static boolean allZero(int[] charMap) {
        for (int i : charMap) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
