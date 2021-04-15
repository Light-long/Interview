package com.tx.dfs;

public class LC200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length<0) return 0;
        // 结果
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        // 遍历这个二维数组，找到为1的元素，然后把他上下左右的所有1变为0，递归此操作
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid,i,j,row,col);
                }
            }
        }
        return res;
    }

    // dfs
    public void dfs(char[][] grid,int i,int j,int row,int col) {
        // 如果下标不越界，或者当前为0，则退出
        if (i<0 || j<0 || i>=row || j>=col || grid[i][j] == '0') {
            return;
        }
        // 设为0
        grid[i][j] = '0';
        // 递归其上下左右
        dfs(grid, i-1, j, row, col);
        dfs(grid, i+1, j, row, col);
        dfs(grid, i, j-1, row, col);
        dfs(grid, i, j+1, row, col);
    }
}
