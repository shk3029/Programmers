package com.company.leetcode;

public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins_binarysearch(0));

    }

    public static int arrangeCoins(int n) {
        int i = 0;
        int result = n;
        while (true) {
            result = result - i;
            if (result <= i) break;
            i++;
        }
        return i;
    }

public static int arrangeCoins_binarysearch(int n) {
    int left = 1;
    int right = n;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if ((mid * (mid + 1L)) / 2L <= n) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return right;
}



}
