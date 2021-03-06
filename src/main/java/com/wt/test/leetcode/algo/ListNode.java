package com.wt.test.leetcode.algo;

/**
 * 面试题 02.01. 移除重复节点
 *
 * @author 一贫
 * @date 2020/9/27
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
