package com.wt.test.leetcode.algo;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author 一贫
 * @date 2020/9/16
 */
public class Problem226 {


    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode swap = root.left;
        root.left = root.right;
        root.right = swap;
        invert(root.left);
        invert(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
