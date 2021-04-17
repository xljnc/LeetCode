package com.wt.test.leetcode.algo;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author 一贫
 * @date 2021/3/25
 */
public class Problem82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(-200);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val != curr.next.next.val)
                curr = curr.next;
            else {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            }
        }
        return dummy.next;
    }

}
