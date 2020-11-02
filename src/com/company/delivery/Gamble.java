package com.company.delivery;

public class Gamble {
    public static void main(String[] args) {
        System.out.println(solution(8,2));
        System.out.println(solution(100,100));
        System.out.println(solution(50,5));
        System.out.println(solution(500,52));
        System.out.println(solution(1000,0));
        System.out.println(solution(50,100));
        System.out.println(solution(12312310,100));
        System.out.println(solution(2147483647,100));
    }

    public static int solution(int N, int K) {
        int betAfterAllIn = 0;
        int allIn=0;
        while (allIn<K) {
            if (N % 2 == 1) betAfterAllIn++;
            N /= 2;
            if (N < 2) break;
            allIn++;
        }
        N = N == 1 ? N : N-1; // 칩이 1개일때는 올인이 불가능
        return N + allIn + betAfterAllIn;
    }
}
/*
1
2
3
6
12
24
25
50
100
 */
