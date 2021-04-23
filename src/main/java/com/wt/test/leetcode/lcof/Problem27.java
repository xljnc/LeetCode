package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author 一贫
 * @date 2021/4/23
 */
public class Problem27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        mirrorTree(left);
        mirrorTree(right);
        return root;
    }
}
