package com.wt.test.leetcode.lcci;

import com.wt.test.leetcode.algo.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 *
 * @author 一贫
 * @date 2020/9/28
 */
public class Problem0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        int step = 0;
        while (step++ < k) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next.val;
    }
}
