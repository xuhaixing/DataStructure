package com.xhx.lc;

public class LC547 {

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] M) {
        int count = 0;
        for(int i = 0; i < M.length; i++){
            for(int j = i; j < M[i].length; j++){
                if(M[i][j] == 1){
                    dfs(M, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, int j) {
        if(i < 0 || i >= M.length || j < 0|| j >= M[i].length){
            return;
        }
        if(M[i][j] == 0){
            return;
        }
        M[i][j] = 0;
        M[j][i] = 0;
        for (int t = 0; t < M.length; t++) {
            dfs(M, t, j);
        }
        for (int t = 0; t < M[i].length; t++) {
            dfs(M, i, t);
        }
    }

}
