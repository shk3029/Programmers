package com.company.codility;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public int solution(int[] A) {
        int result = 1;

        Set<Integer> set = new HashSet<>();
        for (int i : A) if (i>0) set.add(i);

        for (int i=1; i<=set.size()+1; i++) {
            if (!set.contains(i)) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[100000];
        for (int i=1; i<=100000; i++) {
            A[i-1] = i;
        }
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(A));
    }
}
