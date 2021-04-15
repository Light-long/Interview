package com.tx.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC938 {

    // 递归
    public int rangeSumBST1(TreeNode root, int low, int high) {
        // 终止条件
        if (root == null) return 0;
        // 求左子树的和
        int leftSum = rangeSumBST1(root.left,low,high);
        // 求右子树的和
        int rightSum = rangeSumBST1(root.right,low,high);
        // 总和
        int res = leftSum+rightSum;
        // 判断当前节点值是否在范围内
        if (root.val >= low && root.val <= high) {
            res+=root.val;
        }
        return res;
    }

    // bfs
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        // 结果和
        int res = 0;
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将root放入queue
        queue.add(root);
        while (queue.size() > 0) {
            // 当前一层元素的个数，queue的size
            int size = queue.size();
            while (size > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.val >= low && curNode.val<= high) {
                    res+=curNode.val;
                }
                // 将root的左子树的值加入queue
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                // 将root的右子树的值加入queue
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                // 当前一层遍历完成,跳出内层循环
                size--;
            }
        }
        return res;
    }
}
