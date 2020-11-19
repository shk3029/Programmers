package com.company.leetcode.problem;

import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        System.out.println(n);
        /*
        n=1, () - 0
        n=2, (( )),  ()() - 0,1/ 0,2
        n=3, ((())), (()()), (())(),/ ()(()), ()()() - 5)  0,1,2 / 0,1,3, / 0,1,4 / 0,2,3 / 0,2,4 /
         */

        return null;
    }
}

