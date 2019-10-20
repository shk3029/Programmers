package com.company.lv2.stackAndQueue;

import com.company.common.TestDescription;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ProgressesTest {

    // param
    int[] progresses = null;
    int[] speeds = null;

    @Before
    public void setUp() {
        //progresses = new int[]{93, 30, 55, 20, 80, 50, 20};
        progresses = new int[]{40,50,93, 30, 55, 60, 65,20,30};
        //progresses = new int[]{93, 30, 55, 60, 40, 65};
        //speeds = new int[]{1,30,5, 50, 2, 30, 10};
        speeds = new int[]{60,50, 1, 30, 5 , 10, 7,2,2};
        //speeds = new int[]{1, 30, 5 , 10, 60, 7};
    }

    @Test
    @TestDescription("기능 테스트 1 : 각각 작업일이 얼마나 걸리는지 계산하여 큐에 넣기")
    public void createMapAndPutStack() {
        Queue<Integer> queue = getDayQueue();
    }

    @Test
    @TestDescription("기능 테스트 2 : 큐에서 하나씩 꺼내어 count만 배열로 생성")
    public void getQueueAndCreateArrayCount() {
        // 큐에서 하나씩 꺼냄, 이후 day가 더 적은 숫자면 + 1
        int[] result = getQueueCreateResult();
        for(int i : result) {
            System.out.println(i);
        }
    }

    private int[] getQueueCreateResult() {
        Queue<Integer> queue = getDayQueue();
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

    private Queue getDayQueue() {
        Queue<Integer> queue = new LinkedList<>();
        // 작업일 계산, 스택에 넣기
        for(int i=0; i<progresses.length; i++) {
            int day = 1;
            while(progresses[i] + day * speeds[i] < 100) {
                day++;
            }
            queue.add(day);
        }
        System.out.println(queue);
        return queue;
    }

}














