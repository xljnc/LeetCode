package com.wt.test.leetcode.lcci;

/**
 * 面试题 03.02. 栈的最小值
 * https://leetcode-cn.com/problems/min-stack-lcci/
 * 来自评论里的思路
 * 使用链表实现，每个节点保存当时链表中的最小值。
 * pop时可以直接去掉头，剩下的头结点依然保存着当时链表的最小值
 *
 * @author 一贫
 * @date 2020/9/29
 */
public class Problem0302 {

    public static void main(String[] args) {

    }


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

        public int getMin() {
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

