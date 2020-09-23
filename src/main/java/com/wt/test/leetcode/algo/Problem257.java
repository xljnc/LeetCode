package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 深度优先,递归解决
 *
 * @author 一贫
 * @date 2020/9/4
 */
public class Problem257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> result = binaryTreePaths(root);
//        List<String> result = binaryTreePaths(null);
        System.out.println(result);

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        travel(root, "", result);
        return result;
    }

    public static void travel(TreeNode node, String curr, List<String> result) {
        if (node == null)
            return;
        curr = curr + "->" + node.val;
        if (isLeaf(node)) {
            result.add(curr.substring(2));
            return;
        }
        if (node.left != null)
            travel(node.left, curr, result);
        if (node.right != null)
            travel(node.right, curr, result);
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


