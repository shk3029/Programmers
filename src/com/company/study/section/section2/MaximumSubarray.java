package com.company.study.section.section2;

/**
* https://leetcode.com/problems/maximum-subarray/
 */

// nums : -2 1 -3 4 -1 2 1 -5 4
// dp   : -2 1 -2 4  3 5 6  1 5
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i-1];
            }
            max = dp[i] > max ? dp[i] : max;
        }

        return max;
    }
}














