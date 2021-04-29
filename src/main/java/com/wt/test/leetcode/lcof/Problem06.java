package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author 一贫
 * @date 2021/4/29
 */
public class Problem06 {
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;
        while (head != null) {
            deque.addFirst(head.val);
            count++;
            head = head.next;
        }
        int[] result = new int[count];
        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = deque.pollFirst();
        }
        return result;
    }
}
