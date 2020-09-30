package com.company.codility;

public class CountDiv {
    public int solution(int A, int B, int K) {

        int AK = 0;
        for (int i=A; i<=B; i++) {
            if (i % K == 0) {
                AK = i;
                break;
            }
        }

        if (A==B) return A%K == 0 ? 1 : 0;
        int result = B/K - AK/K;
        return result+1;
    }

    public static void main(String[] args) {


    }

}
