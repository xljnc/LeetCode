package com.wt.test.leetcode.algo;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author 一贫
 * @date 2020/10/23
 */
public class Problem234 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        //找中间位置
        if (head == null || head.next == null)
            return true;
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
        //对比
        root = head;
        while (pre != null && root != null) {
            if (pre.val != root.val)
                return false;
            pre = pre.next;
            root = root.next;
        }
        return true;
    }

}
