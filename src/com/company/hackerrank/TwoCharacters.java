package com.company.hackerrank;

import java.util.*;

public class TwoCharacters {
    // Complete the alternate function below.
    static int alternate(String s) {

        Map<Character, Integer> map = new HashMap<>();
        List<Character> inputList = new ArrayList<>();

        // n
        for (char c : s.toCharArray()) {
            inputList.add(c);
            map.putIfAbsent(c, 0);
            map.computeIfPresent(c, (key,val)->val+1);
        };

        List<Character> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        // n
        for (char i : map.keySet()) keys.add(i);
        // n
        for (int i : map.values()) values.add(i);

        Set<Set<Character>> setSet = new HashSet<>();
        // n2
        for (int i=0; i<values.size(); i++) {
            for (int j=0; j<values.size(); j++) {
                if (Math.abs(values.get(j)-values.get(i)) <= 1) {
                    Set<Character> set = new HashSet<>();
                    set.add(keys.get(i));
                    set.add(keys.get(j));
                    if (set.size() == 2) setSet.add(set);
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();
        // m
        for (Set<Character> set : setSet) {
            boolean isAlternate = true;
            List<Character> characters = new ArrayList<>();
            char before = ' ';
            // n
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    if (before == c) isAlternate = false;
                    characters.add(c);
                    before = c;
                }
            }
            if (isAlternate) resultList.add(characters.size());
        }

        Collections.sort(resultList, Comparator.reverseOrder());
        return resultList.size() != 0 ? resultList.get(0) : 0;
    }

    public static void main(String[] args){

        String s = "asvkugfiugsalddlasguifgukvsa";
        int result = alternate(s);
        System.out.println(result);
    }
}

