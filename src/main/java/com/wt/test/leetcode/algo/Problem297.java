package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author 一贫
 * @date 2021/6/30
 */
public class Problem297 {

    public static void main(String[] args) {
        Problem297 problem297 = new Problem297();
        String data = "[1,2,3,null,null,4,5,6,7]";
        TreeNode treeNode = problem297.deserialize(data);
        System.out.println(treeNode);
        String result = problem297.serialize(treeNode);
        System.out.println(result);
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        List<String> result = new ArrayList<>();
        List<TreeNode> row = new ArrayList<>(1);
        row.add(root);
        boolean flag = true;
        while (row.size() != 0 && flag) {
            flag = false;
            List<TreeNode> nextRow = new ArrayList<>();
            for (TreeNode node : row) {
                if (node == null)
                    result.add("null");
                else {
                    result.add(String.valueOf(node.val));
                    nextRow.add(node.left);
                    nextRow.add(node.right);
                    if (node.left != null || node.right != null)
                        flag = true;
                }
            }
            row = nextRow;
        }
        int last = result.size() - 1;
        for (int i = last; i >= 0; i--) {
            if (!result.get(i).equals("null")) {
                last = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= last; i++) {
            sb.append(result.get(i)).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString() + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("[]"))
            return null;
        data = data.substring(1, data.length() - 1);
        String[] datas = data.split(",");
        Integer[] input = new Integer[datas.length];
        for (int i = 0; i < datas.length; i++) {
            input[i] = datas[i].equals("null") ? null : Integer.valueOf(datas[i]);
        }
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


}
