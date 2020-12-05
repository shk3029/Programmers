package com.leetcode.before;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(matrix);
        rotate(matrix2);
    }


    public static void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                result[j][i] = matrix[matrix.length-1-i][j];
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                matrix[i][j] = result[i][j];
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
