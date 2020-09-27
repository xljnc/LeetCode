package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 一贫
 * @date 2020/9/24
 */
public class TreeUtils {

    public static void main(String[] args) {
        Integer[] input = {5, 4, 7, 3, null, 2, null, -1, null, 9};
        TreeNode result = arrayLevelToTree(input);
        List<Integer> travel = inOrderTraverse(result);
        System.out.println(travel);
    }

    public static List<Integer> inOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inTraverse(root, result);
        return result;
    }

    public static void inTraverse(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        inTraverse(root.left, result);
        result.add(root.val);
        inTraverse(root.right, result);
    }


    public static TreeNode arrayLevelToTree(Integer[] input) {
        if (input == null || input.length == 0)
            return null;
        TreeNode root = new TreeNode(input[0]);
        int index = 1;
        List<TreeNode> row = new ArrayList<>(1);
        row.add(root);
        while (index < input.length) {
            List<TreeNode> currRow = new ArrayList<>();
            for (TreeNode node : row) {
                if (node == null)
                    continue;
                if (index == input.length)
                    break;
                Integer currVal = input[index++];
                node.left = currVal == null ? null : new TreeNode(currVal);
                currRow.add(node.left);
                if (index == input.length)
                    break;
                currVal = input[index++];
                node.right = currVal == null ? null : new TreeNode(currVal);
                currRow.add(node.right);
            }
            row = currRow;
        }
        return root;
    }


    public static TreeNode fullArrayToTree(Integer[] input) {
        if (input == null || input.length == 0)
            return null;
        TreeNode root = new TreeNode(input[0]);
        treeify(input, root, 0);
        return root;
    }

    public static void treeify(Integer[] input, TreeNode root, int position) {
        int leftIndex = position * 2 + 1;
        if (leftIndex < input.length && input[leftIndex] != null) {
            root.left = new TreeNode(input[leftIndex]);
            treeify(input, root.left, leftIndex);
        }
        int rightIndex = position * 2 + 2;
        if (rightIndex < input.length && input[rightIndex] != null) {
            root.right = new TreeNode(input[rightIndex]);
            treeify(input, root.right, rightIndex);
        }
    }
}

