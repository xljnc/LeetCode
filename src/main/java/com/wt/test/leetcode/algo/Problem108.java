package com.wt.test.leetcode.algo;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author qiyu
 * @date 2021/4/17
 */
public class Problem108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = generate(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode generate(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = generate(nums, start, mid - 1);
        TreeNode right = generate(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
