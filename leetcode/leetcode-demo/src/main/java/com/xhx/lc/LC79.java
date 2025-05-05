package com.xhx.lc;

public class LC79 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean exist = new LC79().exist(board, word);
        System.out.println(exist);
    }


    public boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == word.charAt(0)) {
                    boolean flag = existWord(board, x, y, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int[][] dires = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    char dot = '.';
    private boolean existWord(char[][] board, int i, int j, String word, int p) {
        if (word.length() == p) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }
        if (board[i][j] == word.charAt(p)) {
            board[i][j] = dot;
            for (int[] dire : dires) {
                boolean flag = existWord(board, i + dire[0], j + dire[1], word, p + 1);
                if (flag) {
                    return flag;
                }
            }
            board[i][j] = word.charAt(p);
        }

        return false;
    }
}
