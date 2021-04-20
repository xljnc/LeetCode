package com.wt.test.leetcode.lcof;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * @author 一贫
 * @date 2021/4/20
 */
public class Problem30 {

    static class MinStack {

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            Node node = new Node();
            node.val = x;
            if (head == null) {
                node.min = x;
                head = node;
            } else {
                if (x < head.min)
                    node.min = x;
                else
                    node.min = head.min;
                node.next = head;
                head = node;
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head == null ? 0 : head.val;
        }

        public int min() {
            return head == null ? 0 : head.min;
        }

        Node head = null;

        static class Node {
            int val;
            Node next;
            int min;

            public Node() {

            }
        }

    }
}
