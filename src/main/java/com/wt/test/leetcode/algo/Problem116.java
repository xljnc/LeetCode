package com.wt.test.leetcode.algo;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author 一贫
 * @date 2020/10/15
 */
public class Problem116 {


    public Node connect(Node root) {
        if (root == null)
            return root;
        Node parent = root;
        while (parent != null) {
            Node start = null;
            Node end = null;
            while (parent != null) {
                if (parent.left != null) {
                    if (start == null)
                        start = parent.left;
                    if (end != null)
                        end.next = parent.left;
                    end = parent.left;
                }
                if (parent.right != null) {
                    if (start == null)
                        start = parent.right;
                    if (end != null)
                        end.next = parent.right;
                    end = parent.right;
                }
                parent = parent.next;
            }
            parent = start;
        }
        return root;
    }


    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
