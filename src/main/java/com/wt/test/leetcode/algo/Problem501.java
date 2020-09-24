package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * @author 一贫
 * @date 2020/9/24
 */
public class Problem501 {

    private List<Integer> result = new ArrayList<>(Arrays.asList(0));

    private int curr;

    private int currCount;

    private int maxCount;

    public static void main(String[] args) {
        Problem501 problem501 = new Problem501();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        int[] result = problem501.findMode(root);
        ArrayUtils.printString(result);
    }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        find(root);
        if (currCount == maxCount)
            result.add(curr);
        else if (currCount > maxCount)
            result = new ArrayList<>(Arrays.asList(curr));
        return Arrays.stream(result.toArray(new Integer[result.size()])).mapToInt(Integer::valueOf).toArray();
    }

    public void find(TreeNode root) {
        if (root == null)
            return;
        find(root.left);
        if (root.val == curr)
            currCount++;
        else {
            if (currCount > maxCount) {
                maxCount = currCount;
                result = new ArrayList<>(Arrays.asList(curr));
            } else if (currCount == maxCount) {
                maxCount = currCount;
                result.add(curr);
            }
            curr = root.val;
            currCount = 1;
        }
        find(root.right);
    }
}
