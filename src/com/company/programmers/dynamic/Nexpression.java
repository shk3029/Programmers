package com.company.programmers.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 사칙연산을 표현하는 문제이다
 * N이 주어지면, N과 사칙연산만으로 number를 표현해보자
 * 예를 들어,
 * 12이면 5+5+(5/5)+(5/5), 55/5 + 5/5, (55+5)/5
 * 5를 사용한 횟수는 각각 6, 5, 4이다
 * 가장 적게 사용한 횟수 4를 출력하면 된다
 * 1 <= N <= 9 , 1<=number<=32000
 * 사칙연산만 가능하고 나머지 연산에서 나머지는 무시
 * 최솟값이 8보다 크면 -1을 리턴
 */

public class Nexpression {
    public static void main(String[] args) {
        Nexpression nexpression = new Nexpression();
        int N = 5;
        int number = 12;
        int solution = nexpression.solution(N, number);
        System.out.println(solution);
    }

    public int solution(int N, int number) {
        int maxCount = 8;

        List<Integer> list = new ArrayList<>();

        for (int i=1; i<=maxCount; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=1; j<=i; j++) stringBuilder.append(N);
            list.add(Integer.parseInt(stringBuilder.toString()));
        }

        System.out.println(list);
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));

        }



        return -1;
    }

    enum Calculator {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPL,
    }
}











