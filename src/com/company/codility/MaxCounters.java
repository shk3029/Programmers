package com.company.codility;

public class MaxCounters {

    public int[] solution(int N, int[] A) {

        int[] X = new int[N];

        int max = 0;
        int currentMax = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] == N + 1) {
                max = currentMax;
            } else {

            }

            if (A[i] >= 1 && A[i] <= N) {

                int value = X[A[i] - 1] + 1;
                currentMax = value > max ? value : max;

                if (A[i] == N + 1) {
                    max = currentMax;
                    value = currentMax + 1;
                    currentMax = 0;
                }

                X[A[i] - 1] = value;


            }
        }

        for (int i = 0; i < X.length; i++) {
            X[i] = X[i] + max;
        }

        return X;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;
        MaxCounters maxCounters = new MaxCounters();

        System.out.println();

        int[] solution = maxCounters.solution(N, A);
        for (int i : solution) {
            System.out.println(i);
        }
    }


}














