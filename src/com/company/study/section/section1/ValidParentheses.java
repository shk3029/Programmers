package com.company.study.section.section1;

import java.util.*;

/**
https://leetcode.com/problems/valid-parentheses/
20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

EX1
Input: s = "()"
Output: true

EX2
Input: s = "()[]{}"
Output: true

EX3
Input: s = "(]"
Output: false

EX4
Input: s = "([)]"
Output: false

EX5
Input: s = "{[]}"
Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        isValid("([]){");
    }

    public static boolean isValid(String s) {
        boolean result = false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> open_stack = new Stack<>();
        Set<Character> open_set = new HashSet<>();
        open_set.addAll(Set.of('(','[','{'));
        Set<Character> close_set = new HashSet<>();
        close_set.addAll(Set.of(')',']','}'));

        for (char c  : s.toCharArray()) {
            if (open_set.contains(c)) {
                open_stack.push(c);
            } else if (close_set.contains(c)) {
                char close_c = map.get(c);
                if (open_stack.isEmpty()) {
                    result = false;
                } else {
                    result =  close_c == open_stack.pop() ? true : false;
                }
                if (!result) break;
            }
        }

        result = open_stack.isEmpty() ? result : false;
        return result;
    }
}












