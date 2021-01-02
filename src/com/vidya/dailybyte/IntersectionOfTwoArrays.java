package com.vidya.dailybyte;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 349. Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};

        System.out.println(Arrays.toString(interSection(nums1,nums2)));

        System.out.println(Arrays.toString(interSection1(nums1,nums2)));
    }

    static int[] interSection(int[] num1, int[] num2) {

        Set<Integer> numSet = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : num2) {
            numSet.add(num);
        }

        for (int num : num1) {
            if (numSet.contains(num)) {
                result.add(num);
            }
        }
        int i = 0;
        int[] resultint = new int[result.size()];
        for(Integer val: result){
            resultint[i++] = val;
        }

        return resultint;
    }

    static int[] interSection1(int[] nums1, int[] nums2){
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(e-> set.contains(e)).toArray();
    }
}
