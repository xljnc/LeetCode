package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author 一贫
 * @date 2021/4/30
 */
public class Problem24 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head.next = null;
        return pre;
    }
}
