package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author qiyu
 */
public class Problem113 {
    public static void main(String[] args) {
        Problem113 problem113 = new Problem113();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Integer> currPath = new ArrayList<>();
        path(root, 0, currPath, result, sum);
        return result;
    }

    public void path(TreeNode root, int currVal, List<Integer> currPath, List<List<Integer>> result, int sum) {
        if (root == null)
            return;
        if (isLeaf(root) && currVal + root.val == sum) {
            List<Integer> newPath = new ArrayList<>(currPath);
            newPath.add(root.val);
            result.add(newPath);
        } else {
            currVal = currVal + root.val;
            currPath.add(root.val);
            path(root.left, currVal, currPath, result, sum);
            path(root.right, currVal, currPath, result, sum);
            currPath.remove(currPath.size() - 1);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
