package com.wt.test.leetcode.algo;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author 一贫
 * @date 2020/9/3
 */
public class Problem2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode result = root;
        boolean needAdd = false;
        do {
            if(l1 == null)
                l1 = new ListNode(0);
            if(l2 == null)
                l2 = new ListNode(0);
            ListNode node = new ListNode(0);
            int sum = l1.val + l2.val + (needAdd ? 1 : 0);
            node.val = sum > 9 ? (sum - 10) : sum;
            needAdd = sum > 9;
            root.next = node;
            root = root.next;
            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null || l2 != null);
        if(needAdd)
            root.next = new ListNode(1);
        return result.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
