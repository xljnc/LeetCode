package com.wt.test.leetcode.algo;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author 一贫
 * @date 2021/3/26
 */
public class Problem83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode result = head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return result;
    }


    private static class ListNode {
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
