package com.wt.test.leetcode.algo;

/**
 * 404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 *
 * @author 一贫
 * @date 2021/4/2
 */
public class Problem404 {

    public static void main(String[] args) {
        Problem404 problem404 = new Problem404();
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        int result = problem404.sumOfLeftLeaves(root);
        System.out.println(result);
    }

    private int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                result += root.left.val;
            else
                traverse(root.left);
        }
        traverse(root.right);
    }

}
