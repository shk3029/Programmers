package com.company.mobility_sk;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
/*
        int[] A = new int[100000];
        for(int i = 0; i<100000 ; i++){
            A[i] = i+1;
        }*/
        int[] A = {3,4,5,4};

        solution(A);
    }

    public static int solution(int[] A) {
        int resultCount= 0;
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<A.length; i++) {
            list.remove(i);
            boolean sort = true;
            for (int j=0; j<list.size()-1; j++) {
                if (list.get(j+1) < list.get(j)) sort = false;
            }
            if (sort) resultCount++;
            list.add(i, A[i]);
        }

        return resultCount;
    }
}
