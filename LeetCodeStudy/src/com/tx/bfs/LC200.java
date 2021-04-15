package com.tx.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC200 {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length== 0) return 0;
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        // bfs
        // queue存放索引
        Queue<int[]> queue = new LinkedList<>();
        // 遍历grid
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == '1') {
                    result++;
                    // 把这个元素放入queue
                    queue.add(new int[]{i,j});
                    // 将grid[i][j]改为0
                    grid[i][j] = '0';
                    // 遍历queue
                    while (queue.size() > 0) {
                        // 将队列头元素弹出，即1位置的索引
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        // 将这个元素的上下左右为1的元素都变为0
                        if (x-1>=0 && grid[x-1][y] == '1') {
                            queue.add(new int[] {x-1,y});
                            grid[x-1][y] = '0';
                        }
                        if (y-1>=0 && grid[x][y-1] == '1') {
                            queue.add(new int[] {x,y-1});
                            grid[x][y-1] = '0';
                        }
                        if (x+1<row && grid[x+1][y] == '1') {
                            queue.add(new int[] {x+1,y});
                            grid[x+1][y] = '0';
                        }
                        if (y+1<col && grid[x][y+1] == '1') {
                            queue.add(new int[] {x,y+1});
                            grid[x][y+1] = '0';
                        }
                    }
                }
            }
        }
        return result;
    }
}
