package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author 一贫
 * @date 2021/4/30
 */
public class Problem25 {
    public static void main(String[] args) {
        Problem25 problem25 = new Problem25();
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        ListNode result = problem25.mergeTwoLists(l1, l2);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        return result.next;
    }
}
