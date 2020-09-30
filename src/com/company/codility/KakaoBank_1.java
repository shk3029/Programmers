package com.company.codility;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class KakaoBank_1 {

    public String solution(String s1, String s2) {
        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();

        char[] chars_s2 = s2.toCharArray();
        for (char c  :s1.toCharArray()) {
            queue.add(c);
            stack.add(c);
        }

        StringBuilder queueArray = new StringBuilder();
        while (!queue.isEmpty()) {
            if (queue.peek() == chars_s2[chars_s2.length-1]) {
                queueArray.append(queue.poll());
                break;
            }
            queueArray.append(queue.poll());
        }

        StringBuilder stackArrary = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.peek() == chars_s2[0]) {
                stackArrary.append(stack.pop());
                break;
            }
            stackArrary.append(stack.pop());
        }

        int queue_size = queueArray.toString().length();
        int stack_size = stackArrary.toString().length();

        StringBuilder stringBuilder = new StringBuilder();

        if (stack_size > queue_size)  for (char c : stack) stringBuilder.append(c);
        for (char c : chars_s2) stringBuilder.append(c);
        if (queue_size > stack_size)  for (char c : queue) stringBuilder.append(c);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        KakaoBank_1 one = new KakaoBank_1();
        String s1 = "xyZAA";
        String s2 = "xyZA";
        System.out.println(one.solution(s1,s2));

        s1 = "AxA";
        s2 = "AyA";
        System.out.println(one.solution(s1,s2));
    }
}
