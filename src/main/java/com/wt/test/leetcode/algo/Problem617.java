package com.wt.test.leetcode.algo;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author 一贫
 * @date 2020/9/23
 */
public class Problem617 {
    public static void main(String[] args) {
        Problem617 problem617 = new Problem617();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        problem617.mergeTrees(t1, t2);
        System.out.println(t1);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return t1;
        if (t1 == null)
            t1 = new TreeNode(0);
        if (t2 == null)
            t2 = new TreeNode(0);
        t1.val = t1.val + t2.val;
        TreeNode left = mergeTrees(t1.left, t2.left);
        t1.left = left;
        TreeNode right = mergeTrees(t1.right, t2.right);
        t1.right = right;
        return t1;
    }

}
