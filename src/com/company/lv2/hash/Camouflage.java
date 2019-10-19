package com.company.lv2.hash;

import java.util.HashMap;

// 위장
public class Camouflage {

    //String[][] clothes = {{"1", "a"}, {"2", "b"}, {"3", "c"}, {"4", "a"}};

    public int Solution(String[][] clothes) {
        int sum = 1;
        // var result = getCountSameValue(); // 내가 처음짠 코드
        var result = refactoringMap(clothes); // 리팩토링 코드
        for (String key : result.keySet()) {
            sum *= (result.get(key) + 1);
        }
        return sum;
    }

    private HashMap<String, Integer> refactoringMap(String[][] clothes) {
        var map = new HashMap<String, Integer>();
        for (String[] strs : clothes) {
            int count = 0;
            String key = strs[1]; // 각 배열의 두번째 원소를 키 값으로 저장
            if (map.containsKey(key)) {
                count = map.get(key);
            }
            map.put(key, count + 1);
        }
        return map;
    }
}
