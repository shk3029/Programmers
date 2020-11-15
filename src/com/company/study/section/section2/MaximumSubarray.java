package com.company.study.section.section2;

import java.util.Arrays;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * Follow up: If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * dp 문제
 *
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        System.out.println("start");
        System.out.println(Arrays.toString(nums));

        int[] dp = new int[nums.length];

        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
        int max = 6;
        // nums : -2 1 -3 4 -1 2 1 -5 4
        // dp   : -2 1 -2 4  3 5 6  1 5

        // 이전 숫자 - 이면,
        //
        // 이전 숫자 + 이면,
        //

        for (int num : nums) {

        }
        return 0;
    }
}
