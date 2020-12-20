package com.vidya.dailybyte;

import java.util.HashMap;
import java.util.Map;

/**
 * This question is asked by Google. Given an array of integers, return whether or not two numbers sum to a given target, k.
 * Note: you may not sum a number with itself.
 * <p>
 * Ex: Given the following...
 * <p>
 * [1, 3, 8, 2], k = 10, return true (8 + 2)
 * [3, 9, 13, 7], k = 8, return false
 * [4, 2, 6, 5, 2], k = 4, return true (2 + 2)
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 2};
        System.out.println(twoSum(nums, 10));

        int[] nums1 = {3, 9, 13, 7};
        System.out.println(twoSum(nums1, 8));

        int[] nums2 = {4, 2, 6, 5, 2};
        System.out.println(twoSum(nums2, 4));

    }

    static boolean twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int compliment = target - nums[i];

            if (numMap.containsKey(compliment)) {
                return true;
            }
            numMap.put(nums[i], i);
        }

        return false;
    }
}
