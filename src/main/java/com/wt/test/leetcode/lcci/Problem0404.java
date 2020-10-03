package com.wt.test.leetcode.lcci;

import com.wt.test.leetcode.algo.TreeNode;

/**
 * 面试题 04.04. 检查平衡性
 * https://leetcode-cn.com/problems/check-balance-lcci/
 *
 * @author 一贫
 * @date 2020/10/3
 */
public class Problem0404 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (!isBalanced(root.left))
            return false;
        if (!isBalanced(root.right))
            return false;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.abs(left - right) <= 1;
    }

    public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
