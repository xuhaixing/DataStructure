package com.xhx.lc;

public class LC64 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = new LC64().minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] mins = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int[] gridInner = grid[i];
            for (int j = 0; j < gridInner.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        mins[i][j] = grid[i][j];
                    } else {
                        mins[i][j] = mins[i][j - 1] + grid[i][j];
                    }
                } else {
                    if (j == 0) {
                        mins[i][j] = mins[i - 1][j] + grid[i][j];
                    } else {
                        mins[i][j] = Math.min(mins[i - 1][j], mins[i][j - 1]) + grid[i][j];
                    }
                }
            }
        }
        return mins[grid.length - 1][grid[0].length - 1];

    }
}
