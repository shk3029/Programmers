package com.company.codility;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println("start");
    }

    public int solution(int N) {
        // 2진수 변환 - 1. Integer.toBinaryString()
         String binaryString = Integer.toBinaryString(N);
        // 2진수 변환 - 2. 직접 구
        //String binaryString = integerToBinaryStr(N);

        List<Integer> numOfZeroList = new ArrayList<>();
        int numOfZero = 0;
        for(char i : binaryString.toCharArray()) {
            if(i=='1') {
                numOfZeroList.add(numOfZero);
                numOfZero = 0;
            } else {
                numOfZero++;
            }
        }
        return numOfZeroList.stream().mapToInt(x->x).max().getAsInt();
    }

    private String integerToBinaryStr(int N) {
        StringBuilder builder = new StringBuilder();
        while(N != 0) {
            builder.append(N%2);
            N = N/2;
        }
        return builder.reverse().toString();
    }
}
