package com.wt.test.leetcode.algo;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author qiyu
 * @date 2021/4/19
 */
public class Problem112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
