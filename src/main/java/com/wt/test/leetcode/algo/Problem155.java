package com.wt.test.leetcode.algo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author 一贫
 * @date 2021/4/7
 */
public class Problem155 {

    static class MinStack {

        private Deque<Node<Integer, Integer>> data;

        private static class Node<k, v> {
            private k key;
            private v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new ArrayDeque<>();
        }

        public void push(int val) {
            Node<Integer, Integer> curr = data.peek();
            if (curr == null || curr.value.compareTo(val) > 0)
                data.push(new Node<>(val, val));
            else
                data.push(new Node<>(val, curr.value));
        }

        public void pop() {
            data.pop();
        }

        public int top() {
            Node<Integer, Integer> curr = data.peek();
            return curr == null ? null : curr.key;
        }

        public int getMin() {
            Node<Integer, Integer> curr = data.peek();
            return curr == null ? null : curr.value;
        }
    }

    static class MinStack1 {

        private Deque<Integer> data;
        private Deque<Integer> minData;

        /**
         * initialize your data structure here.
         */
        public MinStack1() {
            data = new ArrayDeque<>();
            minData = new ArrayDeque<>();
            minData.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            data.push(val);
            minData.push(Math.min(minData.peek(), val));
        }

        public void pop() {
            data.pop();
            minData.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minData.peek();
        }
    }

}
