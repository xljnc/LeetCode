package com.wt.test.leetcode.algo;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * @author 一贫
 * @date 2020/10/20
 */
public class Problem143 {

    public void reorderList(ListNode head) {
        //找中间位置
        if (head == null || head.next == null)
            return;
        int count = 1;
        ListNode root = head;
        while ((root = root.next) != null) {
            count++;
        }
        int step = (count + 1) / 2 - 1;
        root = head;
        while (step-- != 0) {
            root = root.next;
        }
        //右半部分起始节点，倒排
        ListNode mid = root.next;
        root.next = null;
        ListNode pre = mid;
        ListNode curr = mid.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        mid.next = null;
        //合并左右分区
        root = head;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = root.next;
            root.next = pre;
            root = root.next.next;
            pre = next;
        }
    }

}
