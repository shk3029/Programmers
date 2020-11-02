package com.company.delivery;

public class SmallestNumber {
    public static void main(String[] args) {
        System.out.println(getSmallestNumber(1));
        System.out.println(getSmallestNumber(20));
        System.out.println(getSmallestNumber(150));
        System.out.println(getSmallestNumber(199));
        System.out.println(getSmallestNumber(200));
        System.out.println(getSmallestNumber(201));
        System.out.println(getSmallestNumber(999));
        System.out.println(getSmallestNumber(9999999));
        System.out.println(getSmallestNumber(999999999));
        System.out.println(getSmallestNumber(1000000000));
    }

    private static int getSmallestNumber(int N) {
        if (N < 10) return 0;
        int i = 0;
        while (N>0) {
            N /= 10;
            if (N>0) i++;
        }
        return (int) Math.pow(10, i);
    }
}
