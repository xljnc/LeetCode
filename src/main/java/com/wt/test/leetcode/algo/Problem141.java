package com.wt.test.leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author 一贫
 * @date 2020/10/9
 */
public class Problem141 {
    public static void main(String[] args) {
        Problem141 problem141 = new Problem141();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        boolean result = problem141.hasCycle1(head);
        System.out.println(result);
    }

    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next;
            if (fast == slow)
                return true;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 快慢指针
     */
    public boolean hasCycle4(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * -105 <= Node.val <= 105
     * 采用修改遍历过的node的值的方法
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null)
            return false;
        while (head != null) {
            if (head.val == Integer.MAX_VALUE)
                return true;
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return false;
    }

    /**
     * 链表中节点的数目范围是 [0, 10^4]
     * 采用计算大于10^4的方法
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;
        int count = 1;
        while ((head = head.next) != null) {
            count++;
            if (count > 10000)
                return true;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null)
            return false;
        Set<ListNode> nodeSet = new HashSet<>();
        nodeSet.add(head);
        while ((head = head.next) != null) {
            if (nodeSet.contains(head))
                return true;
            nodeSet.add(head);
        }
        return false;
    }
}
