package com.leetcode.before;

/**
 *  f(1) = 1
 *  f(2) = 2
 *  f(3) = (f(1)에서 +2하는 방법) + (f(2)에서 +1하는 방법)
 *  f(4) = (f(2)에서 +2하는 방법) + ((f3)에서 +1하는 방법)
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
    public static int climbStairs(int n) {
        if (n==1 || n==2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}
