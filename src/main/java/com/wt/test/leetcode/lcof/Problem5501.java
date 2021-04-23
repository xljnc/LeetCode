package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.TreeNode;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * @author 一贫
 * @date 2021/4/23
 */
public class Problem5501 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
