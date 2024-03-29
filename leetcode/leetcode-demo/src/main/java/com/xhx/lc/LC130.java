package com.xhx.lc;

public class LC130 {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        //先填充外面四个边
        //然后再循环，填充里面
        for (int i = 0; i < board.length; i++) {
            //左边
            dfs(board, i, 0);
            //右边
            dfs(board, i, board[i].length -  1);
        }
        //上
        for(int i = 0; i < board[0].length; i++){
            dfs(board, 0, i);
        }
        for (int i = 0; i < board[board.length - 1].length; i++) {
            dfs(board, board.length - 1, i);
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0|| j >= board[i].length||board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'T';
        int[][] directs = {{0,1}, {0,-1}, {-1, 0},{1,0}};
        for (int[] direct : directs) {
            dfs(board,i + direct[0],j + direct[1]);
        }
    }
}
