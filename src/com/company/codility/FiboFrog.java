package com.company.codility;

import java.util.*;

/**
 * 개구리가 index -1에서 N까지 도달해야한다
 * 개구리는 F(K)로 점프할 수 있다
 * F는 F(0) = 0 , F(1) = 1, F(M) = F(M-1) + F(M-2) If M>=2 (피보나치)
 * 배열 A가 주어지는데, 0은 나뭇잎이 없고, 1은 나뭇잎이 있다
 * 1을 통해 건너가야한다
 * 목표는 점프를 최소로 해서 목적지에 도달하는 것이다
 * 예를 들면 int[] A = {0,0,0,1,1,0,1,0,0,0,0} 이면,
 * F(5) = 5, F(3) = 2, F(5) = 5로 총 3번만에 도달하므로 3을 리턴한다
 */
public class FiboFrog {
    public static void main(String[] args) {
        FiboFrog fiboFrog = new FiboFrog();
        int[] A = {1,1,0,1,1,1,1,1,0,0,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1};
        int solution = fiboFrog.solution(A);
        System.out.println(solution);
    }

    final static Map<Integer, Integer> fiboMap = new HashMap<>();

    public int solution(int[] A) {
        int N = A.length;
        for (int i=0; fibo(i)<=N+1; i++) fibo(i);

        ArrayList<Integer> fiboList = new ArrayList<>(fiboMap.values());
        Collections.reverse(fiboList);

        Queue<Point> queue = new LinkedList<>();
        boolean[] check = new boolean[N+1];

        queue.add(new Point(-1, 0)); // 시작점

        while(!queue.isEmpty()) {

            Point currentPoint = queue.poll();

            for (int fibo : fiboList) {
                int next = currentPoint.x + fibo;
                if (next == N) {
                    return currentPoint.y + 1;
                } else if (next < N && next >= 0) {
                    if (A[next] == 1 && !check[next]) {
                        check[next] = true;
                        Point point = new Point(next, currentPoint.y + 1);
                        queue.add(point);
                    }
                }
            }
        }

        return -1;
    }

    public int fibo(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        if (fiboMap.containsKey(num)) return fiboMap.get(num);
        fiboMap.put(num, fibo(num-1) + fibo(num-2));
        return fiboMap.get(num);
    }

    class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}













