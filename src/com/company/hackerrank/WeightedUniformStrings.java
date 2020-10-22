package com.company.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class WeightedUniformStrings {
    public static void main(String[] args) {
        String[] abccdddes = weightedUniformStrings("abccddde", new int[]{1,3,12,5,9,10});
        List<String> collect = Arrays.stream(abccdddes).collect(Collectors.toList());
        System.out.println(collect);

    }

    static String[] weightedUniformStrings(String s, int[] queries) {
        int a = 97;
        int z = 122;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=a; i<=z; i++) map.put((char)i, i-96);

        Set<Integer> set = new HashSet<>();
        char befor = ' ';
        int beforSum = 0;
        for (char c : s.toCharArray()) {
            if(befor == c) {
                beforSum += map.get(c);
                set.add(beforSum);
            } else {
                set.add(map.get(c));
                beforSum = map.get(c);
                befor = c;
            }
        }

        String[] strArr = new String[queries.length];

        for (int i=0; i<queries.length ; i++) {
            if (set.contains(queries[i])) {
                strArr[i] = "Yes";
            } else {
                strArr[i] = "No";
            }
        }

        return strArr;
    }


}
