package com.wt.test.leetcode.algo;

/**
 * 1038. 从二叉搜索树到更大和树
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 * @author 一贫
 * @date 2020/9/21
 */
public class Problem1038 {
    private int num = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return root;
        bstToGst(root.right);
        root.val = root.val + num;
        num = root.val;
        bstToGst(root.left);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
