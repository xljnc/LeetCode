package com.wt.test.leetcode.algo;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author 一贫
 * @date 2020/10/20
 */
public class Problem876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public ListNode middleNode1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int count = 1;
        ListNode root = head;
        while ((root = root.next) != null) {
            count++;
        }
        int step = count / 2;
        while (step-- != 0) {
            head = head.next;
        }
        return head;
    }
}
