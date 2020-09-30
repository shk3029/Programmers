package com.company.codility;

import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {
        int fish_0_cnt = 0;
        Stack<Integer> fish_1_stack = new Stack<>();

        for (int i=0; i<A.length; i++) {
            int fishNum = A[i];
            if (B[i] == 1) {
                fish_1_stack.push(fishNum);
            } else {
                if (fish_1_stack.empty()) {
                    fish_0_cnt++;
                } else {
                    int size = fish_1_stack.size();
                    for (int j=0; j<size; j++) {
                        int pop = fish_1_stack.pop();
                        if (fishNum < pop) {
                            fish_1_stack.push(pop);
                            break;
                        }
                    }
                    if (fish_1_stack.size() == 0) fish_0_cnt++;
                }
            }
        }

        return fish_0_cnt + fish_1_stack.size();
    }
    public static void main(String[] args) {
        Fish fish = new Fish();
        int[] A = {4,3,2,1,5};
        int[] B = {1,1,1,1,0};
        System.out.println(fish.solution(A,B));
    }
}
