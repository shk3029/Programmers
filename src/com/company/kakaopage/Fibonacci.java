package com.company.kakaopage;

public class Fibonacci {

    public static void main(StringProblem[] args) {
        Fibonacci main = new Fibonacci();
        main.solution(new long[]{1,9,22,1134903172});

    }

    public long[] solution(long[] longArr) {
        int N = 60;
        long[] memo = new long[N+1];
        fibMemoization(N, memo);

        long[] result = new long[longArr.length+1];

        for (int i=0; i<longArr.length; i++) {
            for (int j=0; j<memo.length; j++) {
                if (longArr[i] < memo[j]) {
                    result[i] = memo[j];
                    System.out.println(result[i]);
                    break;
                }
            }
        }
        return result;
    }

    private static long fibMemoization(int n, long[] memo) {
        if (memo[n] != 0) return memo[n]; // 기록해 둔 것이 있으면 사용
        memo[n] = (n == 1 || n == 2) ? 1 : fibMemoization(n-1, memo) + fibMemoization(n-2, memo); // 기록해 둔 것이 없으면 계산하고 기록
        return memo[n];
    }
}
