package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author 一贫
 * @date 2021/4/23
 */
public class Problem28 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode x, TreeNode y) {
        if (x == null && y == null)
            return true;
        if (x == null || y == null)
            return false;
        if (x.val != y.val)
            return false;
        return check(x.left, y.right) && check(x.right, y.left);
    }

}
