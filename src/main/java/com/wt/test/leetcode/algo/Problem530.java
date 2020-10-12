package com.wt.test.leetcode.algo;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author 一贫
 * @date 2020/10/12
 */
public class Problem530 {

    private int min = Integer.MAX_VALUE;

    private int previous = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Problem530 problem530 = new Problem530();
        Integer[] input = {236, 104, 701, null, 227, null, 911};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        int result = problem530.getMinimumDifference(root);
        System.out.println(result);
    }

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        int diff = Math.abs(root.val - previous);
        min = Math.min(min, diff);
        previous = root.val;
        traverse(root.right);
    }
}
