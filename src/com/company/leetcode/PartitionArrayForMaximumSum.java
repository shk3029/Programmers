package com.company.leetcode;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        maximumSum(new int[]{1,15,10,7,9,2,5}, 3);
    }

    private static int maximumSum(int[] arr, int k) {
        int n =arr.length;
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            int mx = arr[i - 1];
            for (int j = 1; j <= k && i - j >= 0; j++) {
                mx = Math.max(mx, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + (mx * j));
            }
        }
        return dp[n];
    }

}
