package com.company.codility;

import java.util.ArrayDeque;
import java.util.Queue;

public class Nesting {

    public int solution(String s) {

        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) queue.add(c);

        int front = 0;
        int back = 0;

        while (!queue.isEmpty()) {
            if (queue.peek() == ')') {
                queue.poll();
                back++;
                if (front == 0) break;
                front--;
                back--;
            } else if (queue.peek() == '(') {
                queue.poll();
                front++;
            }
        }

        return front+back == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Nesting nesting = new Nesting();
        String s = "(()(())())";
        System.out.println(nesting.solution(s));
    }
}
