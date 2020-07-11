package com.company.interview.IX;

import java.util.HashSet;

public class Array_01 {
    // 1.1
    public String checkDuplicate(String str) {
        HashSet<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++) {
            for(int j=0; j<chars.length; j++) {
                if(i!=j) {
                    if(chars[i] == chars[j])
                        set.add(chars[i]);
                }
            }
        }
        if(set.size() == 0) {
            return "중복 없음";
        } else {
            return "중복된 단어는" + set.toString();
        }
    }

    // 1.2


}
