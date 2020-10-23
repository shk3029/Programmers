package com.company.kakaopage;

public class StringProblem {

    public static void main(java.lang.String[] args) {
        StringProblem main = new StringProblem();
        main.solution("http://page.kakao.com/store");

    }

    public String solution(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean isBeforeAlpha = false;
        for (char c : charArray) {
            if (isAlphaNum(c)) {
                stringBuilder.append(c);
                isBeforeAlpha = true;
            } else {
                if (isBeforeAlpha == true) stringBuilder.append(" ");
                isBeforeAlpha = false;
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isAlphaNum(char c) {
        int index = (int)c;
        if (index >= 48 && index <= 57) return true;
        if (index >= 65 && index <= 122) return true;
        return false;
    }


}
