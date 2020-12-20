package com.vidya.dailybyte;

/**
 * This question is asked by Facebook. Given two strings s and t return whether or not s is an anagram of t.
 * Note: An anagram is a word formed by reordering the letters of another word.
 *
 * Ex: Given the following strings...
 *
 * s = "cat", t = "tac", return true
 * s = "listen", t = "silent", return true
 * s = "program", t = "function", return false
 */
public class ValidAnagram {
    public static void main(String[] args) {

        String s = "cat", t = "tac";
        System.out.println(isValidAnagram(s, t));

        s = "listen"; t = "silent";
        System.out.println(isValidAnagram(s, t));

        s = "program"; t = "function";
        System.out.println(isValidAnagram(s, t));
    }

    static boolean isValidAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int[] charCount = new int[26];

       for(int i = 0;i<s.length();i++){
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
       }

        for (int count: charCount) {
            if(count !=0){
                return false;
            }
        }
        return true;
    }
}
