package com.tx.unionfind;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        // 水的数量
        int waters = 0;
        // 创建一个并查集
        UnionFind uf = new UnionFind(grid);
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == '0') {
                    waters++;
                } else {
                    int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
                    for (int[] dir : directions) {
                        // 二维转换为一维，行号*col+列号
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if (x>=0 && y>=0 && x<row && y<col && grid[x][y] == '1') {
                            uf.union(x*col+y,i*col+j);
                        }
                    }
                }
            }
        }
        return uf.getCount()-waters;
    }
}

// 一维数组，索引等于索引位置的值
public class UnionFind {
    // 一维数组
    private int[] root = null;
    private int count = 0;

    public UnionFind(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        count = row*col;
        root = new int[row*col];
        for (int i=0;i<row*col;i++) {
            root[i] = i;
        }
    }

    // Find the root of X
    // 寻找该索引的祖先
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    // union two element into one root
    public void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
            // union一次
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
