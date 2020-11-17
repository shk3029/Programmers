package com.company.study.section.section2;

public class Fibo {
    public static void main(String[] args) {
        System.out.println(fibo_self(10));
        System.out.println(fibo_dp(10));
    }

    public static int fibo_self(int N) {
        if (N==0 || N==1) return N;
        return fibo_self(N-2) + fibo_self(N-1);
    }

    public static int fibo_dp(int N) {
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }
}
