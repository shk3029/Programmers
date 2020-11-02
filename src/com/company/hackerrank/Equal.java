package com.company.hackerrank;

import java.util.Arrays;

public class Equal {
    public static void main(String[] args) {
        equal(new int[]{2,2,3,7});
    }

    // Complete the equal function below.
    static int equal(int[] arr) {
        Arrays.stream(arr).forEach(x-> System.out.println(x));
        return 0;
    }

}
