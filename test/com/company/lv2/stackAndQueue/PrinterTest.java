package com.company.lv2.stackAndQueue;

import com.company.common.TestDescription;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class PrinterTest {

    int[] priorities = null;
    int location;

    @Before
    public void setUp() {
        priorities = new int[]{2,1,3,2};
        location = 2;
    }

    @Test
    @TestDescription("우선순위큐 ")
    public void compareToNum() {

        int num = searchIdx(priorities, location);
        System.out.println(num);

    }

    private int searchIdx(int[] priorities, int location ) {
        PriorityQueue priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : priorities) {
            priorityQueue.add(num);
        }
        int cnt = 1;
        while(!priorityQueue.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == (int)priorityQueue.peek()) {
                    if(i == location) return cnt;
                    priorityQueue.poll();
                    cnt++;
                }
            }
        }
        return cnt;
    }
}