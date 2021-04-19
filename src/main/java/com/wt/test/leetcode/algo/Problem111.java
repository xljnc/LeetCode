package com.wt.test.leetcode.algo;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author 一贫
 * @date 2021/4/19
 */
public class Problem111 {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int min = Integer.MAX_VALUE;
        if (root.left != null)
            min = Math.min(min, minDepth(root.left));
        if (root.right != null)
            min = Math.min(min, minDepth(root.right));
        return min + 1;
    }
}
