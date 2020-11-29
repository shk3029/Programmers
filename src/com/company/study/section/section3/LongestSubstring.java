package com.company.study.section.section3;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println("start");
        lengthOfLongestSubstring("dvdf");
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();

        for (int i=0; i<charArray.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j=i; j<charArray.length; j++) {
                if (list.contains(charArray[j])) break;
                list.add(charArray[j]);
            }
            if (list.size() > result) result = list.size();
        }
        return result;
    }

}
