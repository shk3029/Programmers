package com.company.programmers.binarysearch;

import java.util.Arrays;

public class Immigration {
    public static void main(String[] args) {
        Immigration immigration = new Immigration();

        int[] times = {7,10};
        int n = 6;

        immigration.solution(n,times);
    }

    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        long left = 1, right = times[times.length-1] * n;
        // left : 1, right : 60 (10*6)
        long mid = 0;

        while (left <= right) {

        }

        return answer;
    }
}

































