package com.wt.test.leetcode.algo;

import java.util.List;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author 一贫
 * @date 2020/9/25
 */
public class Problem106 {
    private int[] inorder;
    private int[] postorder;

    public static void main(String[] args) {
        Problem106 problem106 = new Problem106();
        int[] inorder = {1, 2, 3, 4};
        int[] postorder = {2, 1, 4, 3};
        TreeNode result = problem106.buildTree(inorder, postorder);
        List<Integer> travel = TreeUtils.inOrderTraverse(result);
        System.out.println(travel);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length)
            return null;
        this.inorder = inorder;
        this.postorder = postorder;
        TreeNode head = new TreeNode(0);
        build(head, true, 0, inorder.length - 1, 0, postorder.length - 1);
        return head.left;
    }

    public void build(TreeNode parent, boolean left, int inStart, int inEnd, int postStart, int postEnd) {
        int len = inEnd - inStart + 1;
        if (len == 0)
            return;
        if (len == 1) {
            if (left)
                parent.left = new TreeNode(inorder[inStart]);
            else
                parent.right = new TreeNode(inorder[inStart]);
            return;
        }
        TreeNode mid = new TreeNode(postorder[postEnd]);
        if (left)
            parent.left = mid;
        else
            parent.right = mid;
        int l = 0;
        while (l < len) {
            if (inorder[inStart + l] == mid.val)
                break;
            l++;
        }
        if (l == 0)
            build(mid, false, inStart + l + 1, inEnd, postStart, postEnd - 1);
        else if (l == len - 1)
            build(mid, true, inStart, inStart + l - 1, postStart, postEnd - 1);
        else {
            build(mid, true, inStart, inStart + l - 1, postStart, postStart + l - 1);
            build(mid, false, inStart + l + 1, inEnd, postStart + l, postEnd - 1);
        }
    }
}
