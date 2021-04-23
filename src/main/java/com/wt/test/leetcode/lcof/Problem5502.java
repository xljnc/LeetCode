package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.TreeNode;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 *
 * @author 一贫
 * @date 2021/4/23
 */
public class Problem5502 {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

}
