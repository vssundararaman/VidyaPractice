package com.vidya.dailybyte;

import java.util.HashSet;

public class JewelsAndStones {

    public static void main(String[] args) {

        String jewels = "abc", stones = "ac";
        System.out.println(findJewelsAndStones(jewels,stones));

        jewels = "Af";
        stones = "AaaddfFf";
        System.out.println(findJewelsAndStones(jewels,stones));

        jewels = "AYOPD";
        stones = "ayopd";
        System.out.println(findJewelsAndStones(jewels,stones));
    }

    static int findJewelsAndStones(String jewels, String stones){

        int count = 0;

        for(char jewel: jewels.toCharArray()){
            for(char stone: stones.toCharArray()){
                count += jewel == stone ? 1: 0;
            }
        }

        return count;
    }
}
