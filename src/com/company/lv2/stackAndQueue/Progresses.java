package com.company.lv2.stackAndQueue;

import java.util.*;

public class Progresses {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = getQueueCreateResult(progresses, speeds);
        return answer;
    }

    private int[] getQueueCreateResult(int[] progresses, int[] speeds) {
        Queue<Integer> queue = getDayQueue(progresses, speeds);
        System.out.println(queue);
        var map = new LinkedHashMap<Integer, Integer>();
        int prevDay = 0;
        while(!queue.isEmpty()){
            int day = queue.poll();
            // 처음
            if(map.isEmpty()) {
                map.put(day, 1);
                prevDay = day;
            } else {
                // 이전 날짜가 더 크면 이전 날짜에 +1, 아니면 (새로운 날짜, 1)
                if(prevDay >= day) {
                    map.put(prevDay, map.get(prevDay) + 1);
                } else {
                    map.put(day, 1);
                    prevDay = day;
                }
            }
        }
        Integer[] integerResult = map.values().toArray(Integer[]::new);
        return Arrays.stream(integerResult).mapToInt(Integer::intValue).toArray();
    }

    private Queue getDayQueue(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int day = 1;
            while(progresses[i] + day * speeds[i] < 100) {
                day++;
            }
            queue.add(day);
        }
        return queue;
    }
}
