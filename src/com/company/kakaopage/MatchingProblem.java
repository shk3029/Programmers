package com.company.kakaopage;

import java.util.ArrayList;
import java.util.List;

public class MatchingProblem {
    public static void main(String[] args) {
        boolean solution = solution("Landvibe", "L*d?i*e");
        System.out.println(solution);
    }

    public static boolean solution(String str, String matching) {
        List<String> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : matching.toCharArray()) {
            if (c!='*') stringBuilder.append(c);
            if (c=='*') {
                if (!stringBuilder.toString().isEmpty()) {
                    list.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }

        }
        if (!stringBuilder.toString().isEmpty()) list.add(stringBuilder.toString());

        boolean isMatch = false;

        System.out.println(list);
        for (int i=0; i<list.size(); i++) {
            if (i==0) {
                isMatch = str.startsWith(list.get(i));
            } else if (i==list.size()-1) {
                isMatch = str.endsWith(list.get(i));
            } else {
                for (char c : str.toCharArray()) {

                }
            }
            if (!isMatch)  break;
        }

        return isMatch;

    }

    public static boolean solution2(String str, String matching) {

        char[] charArray = str.toCharArray();
        for (int i=0; i<charArray.length; i++) {

        }

        return false;
    }

}
