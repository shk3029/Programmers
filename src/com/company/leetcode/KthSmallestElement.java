package com.company.leetcode;

import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String[] args) {

        int[][] matrix = {
                {1,5,9},
                {12,13,14},
                {12,13,15}
        };

        int k = 8;

        System.out.println(kthSmallest(matrix, k));
        System.out.println(kthSmallest_binarysearch(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sorted().toArray()[k-1];
    }

    public static int kthSmallest_binarysearch(int [][] matrix, int k) {
        int min = matrix[0][0];
        int max = matrix[matrix.length-1][matrix.length-1];

        while (min <= max) {
            int mid = (max-min)/2 + min;
            int count = 0;

            for (int i=0; i<matrix.length; i++) {
                for (int j=0; j<matrix[i].length; j++) {
                    if (matrix[i][0] > mid) break;
                    if (matrix[i][j] <= mid) count++;
                }
            }

            if (count < k) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        return min;
    }
}
