package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author 一贫
 * @date 2020/9/14
 */
public class Problem94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private static void traverse(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        if (root.left != null)
            traverse(root.left, result);
        result.add(root.val);
        if (root.right != null)
            traverse(root.right, result);

    }
}
