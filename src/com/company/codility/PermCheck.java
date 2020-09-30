package com.company.codility;

import java.util.HashSet;

public class PermCheck {

    public int solution(int[] A) {
        int result = 1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : A) hashSet.add(i);
        for (int i=1; i<=A.length; i++) {
            if (!hashSet.contains(i)) {
                result = 0;
                break; // 시간복잡도를 줄이기위함
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        int[] A = {4,1,2};
        System.out.println(permCheck.solution(A));
    }

}
