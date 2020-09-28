package com.wt.test.leetcode.lcci;

import com.wt.test.leetcode.algo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 *
 * @author 一贫
 * @date 2020/9/27
 */
public class Problem0201 {

    public static void main(String[] args) {

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null)
            return head;
        Set<Integer> bag = new HashSet<>();
        bag.add(head.val);
        ListNode curr = head;
        while (curr.next != null) {
            ListNode del = curr.next;
            if (bag.add(del.val))
                curr = curr.next;
            else
                curr.next = curr.next.next;
        }
        return head;
    }

}
