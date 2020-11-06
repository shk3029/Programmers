package com.company.leetcode.section.section1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
https://leetcode.com/problems/two-sum/
1. Two Sum
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.

Example1
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example2
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example3
Input: nums = [3,3], target = 6
Output: [0,1]
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] exArr_1 = {2, 7, 11, 15};
        int target_1 = 9;

        int[] exArr_2 = {3, 2, 4};
        int target_2 = 6;

        int[] exArr_3 = {0,4,3,0};
        int target_3 = 0;

        for (int i : twoSum(exArr_3, target_3))
            System.out.print(i);
    }


    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i=0; i<nums.length; i++) {
            int s = target - nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] == s) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}




































