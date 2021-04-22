package com.wt.test.leetcode.lcci;

import com.wt.test.leetcode.algo.TreeNode;
import com.wt.test.leetcode.algo.TreeUtils;

/**
 * 面试题 17.12. BiNode
 * https://leetcode-cn.com/problems/binode-lcci/
 *
 * @author 一贫
 * @date 2021/4/22
 */
public class Problem1712 {

    public static void main(String[] args) {
        Problem1712 problem1712 = new Problem1712();
        Integer[] input = {4, 2, 5, 1, 3, null, 6};
        TreeNode treeNode = TreeUtils.arrayLevelToTree(input);
        treeNode = problem1712.convertBiNode(treeNode);
        System.out.println(TreeUtils.inOrderTraverse(treeNode));
    }

    private TreeNode head;

    private TreeNode pre;

    public TreeNode convertBiNode(TreeNode root) {
        convert(root);
        return head;
    }

    private void convert(TreeNode node) {
        if (node == null)
            return;
        convert(node.left);
        if (pre == null)
            head = node;
        else {
            pre.right = node;
            node.left = null;
        }
        pre = node;
        convert(node.right);
    }
}
