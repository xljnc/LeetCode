package com.wt.test.leetcode.algo;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author 一贫
 * @date 2021/4/19
 */
public class Problem110 {


    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }
}
