package com.tx.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        // 把root放入queue
        queue.add(root);
        while (queue.size() > 0) {
            // 当前队列长度
            int size = queue.size();
            // 存放每一层的数据
            List<Integer> list = new ArrayList<>();
            // 遍历完一层需要跳出内层循环一次
            while (size > 0) {
                // 当前节点
                TreeNode cur = queue.poll();
                int val = cur.val;
                // 将当前值放入结合
                list.add(val);
                // 将当前节点的左右孩子都加入队列
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                // 因为当前元素出队列了
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
