package com.wt.test.leetcode.lcci;

import com.wt.test.leetcode.algo.TreeNode;

/**
 * 面试题 04.02. 最小高度树
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 *
 * @author 一贫
 * @date 2020/10/2
 */
public class Problem0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return generate(0, nums.length - 1, nums);
    }

    private TreeNode generate(int start, int end, int[] nums) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(nums[start]);
        int mid = (start + end) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        TreeNode leftNode = generate(start, mid - 1, nums);
        midNode.left = leftNode;
        TreeNode rightNode = generate(mid + 1, end, nums);
        midNode.right = rightNode;
        return midNode;
    }
}
