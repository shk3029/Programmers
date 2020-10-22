package com.company.hackerrank;

import java.util.*;

public class SubarrayDivision {
    public static void main(String[] args) {
        birthday2(List.of(1,2,1,3,2), 3, 2);
    }
    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int result = 0;
        for (int i=0; i<s.size(); i++) {
            int sum = 0;
            for (int j=i; j<i+m; j++) {
                if (i+m <= s.size()) sum += s.get(j);
            }
            if (d==sum) result++;
        }
        return result;
    }

    static int birthday2(List<Integer> s, int d, int m) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
            if (i>=m) sum -= s.get(i - m);
            if (i>=m-1 && sum == d) result++;
        }
        return result;
    }
}
