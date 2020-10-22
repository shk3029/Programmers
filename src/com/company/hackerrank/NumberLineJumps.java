package com.company.hackerrank;

public class NumberLineJumps {
    public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));

    }

    static String kangaroo(int x1, int v1, int x2, int v2) {

        while(true) {
            if (v1<=v2) return "NO";
            x1 = x1 + v1;
            x2 = x2 + v2;
            if (x1==x2) return "YES";
            if (x1>x2) return "NO";
        }

    }
}
