package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author 一贫
 * @date 2020/9/7
 */
public class Problem19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        ListNode result = removeNthFromEnd1(head, 2);
        ListNode result = removeNthFromEnd(head, 2);
        System.out.println(result);
    }

    /**
     * 双指针法，让快慢2个指针都指向head的前一个。
     * 快指针先走n步，然后快慢指针一起走，快指针到底，慢指针指向应被删除节点的前一个。
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    /**
     * 遍历链表，使用List保存节点
     * 空间换时间
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        //遍历链表
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(head);
        ListNode curr = head;
        while ((curr = curr.next) != null) {
            nodes.add(curr);
        }
        if (!hashPrevious(nodes, n) && !hashNext(nodes, n))
            return null;
        if (!hashPrevious(nodes, n) && hashNext(nodes, n))
            return head.next;
        if (hashPrevious(nodes, n) && !hashNext(nodes, n)) {
            ListNode prev = nodes.get(nodes.size() - n - 1);
            prev.next = null;
            return head;
        }
        if (hashPrevious(nodes, n) && hashNext(nodes, n)) {
            ListNode prev = nodes.get(nodes.size() - n - 1);
            ListNode next = nodes.get(nodes.size() - n + 1);
            prev.next = next;
            return head;
        }
        return null;
    }

    public static boolean hashPrevious(List<ListNode> nodes, int n) {
        return nodes.size() > n;
    }

    public static boolean hashNext(List<ListNode> nodes, int n) {
        return n > 1;
    }
}
