package com.wt.test.leetcode.algo;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 * @author 一贫
 * @date 2020/9/30
 */
public class Problem701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            root = new TreeNode(val);
        else
            insert(root, val);
        return root;
    }

    public void insert(TreeNode parent, int val) {
        TreeNode target = new TreeNode(val);
        if (val < parent.val) {
            if (parent.left == null)
                parent.left = target;
            else
                insert(parent.left, val);
        } else {
            if (parent.right == null)
                parent.right = target;
            else
                insert(parent.right, val);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
