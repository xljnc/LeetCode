package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author 一贫
 * @date 2020/10/27
 */
public class Problem144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}
