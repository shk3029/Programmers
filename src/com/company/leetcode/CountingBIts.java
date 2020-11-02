package com.company.leetcode;

public class CountingBIts {

    public static void main(String[] args) {
        countBits(5);
    }

    static int[] countBits(int num) {
        int[] arr = new int[num+1];
        for (int i=0; i<=num; i++) arr[i] = countNum(i);
        return arr;
    }

    private static int countNum(int num) {
        int count = 0;
        while (num > 0) {
            int one = num % 2;
            num /= 2;
            if (one == 1) count++;
        }
        return count;
    }

}
