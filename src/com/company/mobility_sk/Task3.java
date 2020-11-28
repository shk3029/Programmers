package com.company.mobility_sk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {
        solution(3,3);
    }

    public static String solution(int A, int B) {
        StringBuilder result = new StringBuilder();

        Stack<String> stackA = new Stack<>();
        Stack<String> stackB = new Stack<>();

        for (int i=0; i<A; i++) stackA.add("A");
        for (int i=0; i<B; i++) stackB.add("B");

        Stack<String> stackMax = A >= B ? stackA : stackB;
        Stack<String> stackMin = A >= B ? stackB : stackA;

        while (!stackMax.isEmpty() || !stackMin.isEmpty()) {

            if (stackMax.size() == stackMin.size())  {
                if (!stackMax.isEmpty()) result.append(stackMax.pop());
                if (!stackMin.isEmpty()) result.append(stackMin.pop());
            } else {
                if (!stackMax.isEmpty()) result.append(stackMax.pop());
                if (!stackMax.isEmpty()) result.append(stackMax.pop());
                if (!stackMin.isEmpty()) result.append(stackMin.pop());
            }
        }

        return result.toString();
    }
}
