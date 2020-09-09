package com.wt.test.leetcode.algo;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author 一贫
 * @date 2020/9/9
 */
public class Problem21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
        ListNode result = mergeTwoLists(l1, l2);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null && l2 != null) {
            while (l1 != null && l2 != null && l1.val <= l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
            while (l1 != null && l2 != null && l2.val <= l1.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            curr.next = l1;
        else
            curr.next = l2;
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
