package com.wt.test.leetcode.algo;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 * @author 一贫
 * @date 2021/4/27
 */
public class Problem938 {

    public static void main(String[] args) {
        Problem938 problem938 = new Problem938();
        Integer[] input = {10, 5, 15, 3, 7, null, 18};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        int result = problem938.rangeSumBST(root, 7, 15);
        System.out.println(result);
    }

    private int count = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return count;
    }

    public void traverse(TreeNode node, int low, int high) {
        if (node == null)
            return;
        if (node.val >= low && node.val <= high) {
            count += node.val;
            traverse(node.left, low, high);
            traverse(node.right, low, high);
        } else if (node.val < low)
            traverse(node.right, low, high);
        else
            traverse(node.left, low, high);
    }
}
