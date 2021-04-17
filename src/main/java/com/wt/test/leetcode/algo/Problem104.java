package com.wt.test.leetcode.algo;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author 一贫
 * @date 2021/4/16
 */
public class Problem104 {

    public int maxDepth(TreeNode root) {
        return calcDepth(root);
    }

    private int calcDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = calcDepth(root.left);
        int right = calcDepth(root.right);
        int max = Math.max(left, right);
        return 1 + max;
    }

}
