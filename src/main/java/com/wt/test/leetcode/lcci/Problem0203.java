package com.wt.test.leetcode.lcci;

import com.wt.test.leetcode.algo.ListNode;

/**
 * 面试题 02.03. 删除中间节点
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 *
 * @author 一贫
 * @date 2020/9/28
 */
public class Problem0203 {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        if (node.next == null)
            node = null;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
