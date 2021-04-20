package com.wt.test.leetcode.algo;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * @author 一贫
 * @date 2020/9/21
 */
public class Problem538 {

    private int num = 0;

    public static void main(String[] args) {
        Problem538 problem538 = new Problem538();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        problem538.convertBST(root);
        System.out.println(root);
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        convertBST(root.right);
        root.val = root.val + num;
        num = root.val;
        convertBST(root.left);
        return root;
    }

}
