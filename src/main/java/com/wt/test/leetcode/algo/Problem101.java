package com.wt.test.leetcode.algo;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author qiyu
 * @date 2021/4/18
 */
public class Problem101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode x, TreeNode y) {
        if (x == null && y == null)
            return true;
        if (x == null || y == null)
            return false;
        if (x.val != y.val)
            return false;
        return check(x.left, y.right) && check(x.right, y.left);
    }

}
