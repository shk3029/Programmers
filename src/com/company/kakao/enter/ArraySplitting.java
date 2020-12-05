package com.company.kakao.enter;

import java.util.Arrays;

public class ArraySplitting {
    public static void main(String[] args) {
        int[] arr = {-3,-2,10,20,-30};
        ArraySplitting.solution(arr);
    }

    public static int solution(int[] arr) {
        int left_sum= 0;
        int sum = Arrays.stream(arr).sum();
        int cnt = 0;

        for (int i=0; i<arr.length-1; i++) {
            left_sum += arr[i];
            if (left_sum > sum - left_sum) cnt++;
        }
        return cnt;
    }

}
