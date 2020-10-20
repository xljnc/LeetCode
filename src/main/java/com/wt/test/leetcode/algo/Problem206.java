package com.wt.test.leetcode.algo;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author 一贫
 * @date 2020/10/20
 */
public class Problem206 {

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
