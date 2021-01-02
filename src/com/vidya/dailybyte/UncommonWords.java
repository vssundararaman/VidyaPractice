package com.vidya.dailybyte;

import java.util.*;

public class UncommonWords {

    public static void main(String[] args) {
        String  A = "this apple is sweet", B = "this apple is sour";

        System.out.println(Arrays.toString(uncommonWordsFromSentenses(A,B)));

        A = "apple apple"; B = "banana";

        System.out.println(Arrays.toString(uncommonWordsFromSentenses(A,B)));
    }

    static String[] uncommonWordsFromSentenses(String A, String B) {

        String str = A.concat(" ").concat(B);
        String[] words = str.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {

            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>();

        for(String key: map.keySet()){
            if(map.get(key) == 1){
                result.add(key);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
