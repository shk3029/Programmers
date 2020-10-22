package com.company.hackerrank;

import java.util.*;

public class SubarrayDivision {
    public static void main(String[] args) {
        birthday(List.of(1,1, 1, 1, 1, 1), 3, 2);
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
}
