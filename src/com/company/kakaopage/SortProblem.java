package com.company.kakaopage;

import java.util.ArrayList;
import java.util.List;

public class SortProblem {
    public static void main(String[] args) {
        int solution = solution(List.of(19, 21, 31, 42, 44), List.of(1, 2, 3, 4, 15, 16, 17, 28, 29, 30, 41, 43), 8);
        System.out.println(solution);
    }

    public static int solution(List<Integer> list1, List<Integer> list2, int n) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        while(true) {
            int a1 = list1.get(i);
            int a2 = list2.get(j);

            if (a1 < a2) {
                result.add(a1);
                i++;
            } else {
                result.add(a2);
                j++;
            }

            if (a1 == list1.get(list1.size()-1) && a2 == list2.get(list2.size()-1)) {
                if (a1 > a2) {
                    result.add(a1);
                } else {
                    result.add(a2);
                }
                break;
            }
        }
        return result.get(n-1);
    }


}
