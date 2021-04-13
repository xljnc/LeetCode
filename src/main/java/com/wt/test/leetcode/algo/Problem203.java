package com.wt.test.leetcode.algo;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author qiyu
 * @date 2021/4/10
 */
public class Problem203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return start.next;
    }
}
