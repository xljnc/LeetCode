package com.wt.test.leetcode.algo;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author 一贫
 * @date 2020/9/17
 */
public class Problem24 {

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        problem24.swapPairs(head);
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = head.next;
        ListNode curr = new ListNode(0);
        curr.next = head;
        while (curr != null) {
            if (curr.next == null || curr.next.next == null)
                break;
            ListNode pre = curr.next;
            ListNode next = curr.next.next;
            ListNode suc = curr.next.next.next;
            curr.next = next;
            curr.next.next = pre;
            curr.next.next.next = suc;
            curr = pre;
        }
        return result;
    }

}
