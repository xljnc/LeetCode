package com.wt.test.leetcode.algo;

/**
 * 129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * @author 一贫
 * @date 2020/10/29
 */
public class Problem129 {

    private int sum;


    public static void main(String[] args) {
        Problem129 problem129 = new Problem129();
        Integer[] input = {1, 0};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        int result = problem129.sumNumbers(root);
        System.out.println(result);
    }

    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        else
            return traverse(root.left, sum) + traverse(root.right, sum);
    }

    public int sumNumbers1(TreeNode root) {
        if (root == null)
            return 0;
        StringBuilder sb = new StringBuilder();
        backtrace(root, sb);
        return sum;
    }

    private void backtrace(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val);
        if (root.left == null && root.right == null)
            sum += Integer.valueOf(sb.toString());
        else {
            if (root.left != null) {
                backtrace(root.left, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (root.right != null) {
                backtrace(root.right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
