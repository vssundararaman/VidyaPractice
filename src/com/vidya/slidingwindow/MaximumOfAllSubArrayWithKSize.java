package com.vidya.slidingwindow;

import java.util.Arrays;

public class MaximumOfAllSubArrayWithKSize {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlideWindow(nums, k)));
    }

    static int[] maxSlideWindow(int[] nums, int k) {

        int n = nums.length;
        int[] answer = new int[n - k + 1];
        int j, max;
        int index = 0;
        for (int i = 0; i <= n - k; i++) {
            max = nums[i];

            for (j = 1; j < k; j++) {
                if (nums[i + j] > max) {
                    max = nums[i + j];
                }
            }
            System.out.print( max + " ");
            answer[index] = max;
            index++;
        }

        return answer;
    }
}
