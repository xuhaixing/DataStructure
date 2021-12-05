package com.xhx.lc;

/**
 * @description:
 * @author: 徐海兴
 * @Date: 2021/12/5 10:15 下午
 */
public class LC304 {
}

class NumMatrix {

    int[][] preSums;

    public NumMatrix(int[][] matrix) {

        preSums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                preSums[i + 1][j + 1] = matrix[i][j] + preSums[i + 1][j] + preSums[i][j + 1] - preSums[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSums[row2 + 1][col2 + 1] - preSums[row2 + 1][col1] - preSums[row1][col2 + 1] + preSums[row1][col1];
    }
}