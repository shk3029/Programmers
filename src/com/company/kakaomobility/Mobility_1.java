package com.company.kakaomobility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mobility_1 {
    public static void main(String[] args) {
        solution(10);
        solution(30);
        solution(33);
        solution(15);
        solution(0);
        solution(1);
        solution(4);
        solution(100000);
        solution(50000);
        solution(30000);
        solution(10000);
    }

    public static int solution(int num) {
        int clap = 0;
        List<String> clapList = List.of("3", "6", "9");

        for (int i=1; i<=num; i++) {
            String[] arr = Integer.toString(i).split("");
            for (String str : arr) {
                if (clapList.contains(str)) {
                    clap++;
                    break;
                }
            }
        }
        return clap;
    }
}
