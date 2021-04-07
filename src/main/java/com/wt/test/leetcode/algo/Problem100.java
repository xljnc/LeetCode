package com.wt.test.leetcode.algo;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author qiyu
 * @date 2021/4/5
 */
public class Problem100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
