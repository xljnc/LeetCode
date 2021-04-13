package com.wt.test.leetcode.algo;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 *
 * @author 一贫
 * @date 2020/10/13
 */
public class Problem783 {
    private int min = Integer.MAX_VALUE;

    private int previous = Integer.MIN_VALUE;

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return min;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (previous != Integer.MIN_VALUE) {
            int diff = Math.abs(root.val - previous);
            min = Math.min(min, diff);
        }
        previous = root.val;
        traverse(root.right);
    }
}
