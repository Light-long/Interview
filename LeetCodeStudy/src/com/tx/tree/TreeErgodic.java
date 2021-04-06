package com.tx.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class TreeErgodic {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                // 当前节点元素
                list.add(node.val);
                // 放入栈中
                stack.push(node);
                // 指向左节点
                node = node.left;
            }
            // node左节点为null,弹出stack中元素作为node
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            // 遍历到最左节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 判断是否有右节点
            // 没有
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
