package com.company;

import com.company.lv2.stackAndQueue.Progresses;

import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.progresses();

    }

    private void progresses() {
        int[] param1 = new int[]{40, 93, 30, 55, 60, 65};
        int[] param2 = new int[]{60, 1, 30, 5 , 10, 7};
        Progresses progresses = new Progresses();
        for(int i : progresses.solution(param1, param2)) {
            System.out.println(i);
        }
    }
}
