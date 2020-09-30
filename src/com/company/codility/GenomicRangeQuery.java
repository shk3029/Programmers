package com.company.codility;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2,5,0};
        int[] Q  = {4,5,6};

        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        for (int i : genomicRangeQuery.solution(S, P, Q)) {
            System.out.println(i);
        }
    }

    public final static Map<Character, Integer> sequenceMap = new HashMap<>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    public int[] solution(String S, int[] P, int[] Q) {
        char[] charArray = S.toCharArray();
        int[] count = {0,0,0,0};
        int[][] countArry = new int[charArray.length][count.length];

        for (int i=0; i<charArray.length; i++) {
            count[sequenceMap.get(charArray[i])]++; // [0100], [1100], [1110], [1210] ....
            for (int j=0; j<count.length; j++) {
                countArry[i][j] = count[j]; // [[0100],[1100],[1110],[1210]....]
            }
        }

        int M = P.length;
        int[] minArr = new int[M];

        for (int i=0; i<M; i++) {
            for (int j=0; j<count.length; j++) {
                int end = countArry[Q[i]][j];
                int before_start = P[i] == 0 ? 0 : countArry[P[i]-1][j];
                if (end - before_start > 0) {
                    minArr[i] = j+1;
                    break;
                }
            }
        }
        return minArr;
    }
}
