package com.wt.test.leetcode.algo;

/**
 * 897. 递增顺序搜索树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 *
 * @author 一贫
 * @date 2021/4/25
 */
public class Problem897 {

    private TreeNode pre;

    private TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
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
