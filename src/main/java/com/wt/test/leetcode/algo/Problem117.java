package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author 一贫
 * @date 2020/9/28
 */
public class Problem117 {
    public static void main(String[] args) {
        Problem117 problem117 = new Problem117();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        problem117.connect(root);
        System.out.println(root);
    }

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

    public Node connect1(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>(16);
        traverseAndConnect(root, 1, map);
        for (List<Node> nodes : map.values()) {
            for (int i = 0; i < nodes.size(); i++) {
                if (i != nodes.size() - 1)
                    nodes.get(i).next = nodes.get(i + 1);
            }
        }
        return root;
    }

    public void traverseAndConnect(Node parent, int level, Map<Integer, List<Node>> map) {
        if (parent == null)
            return;
        if (!map.containsKey(level))
            map.put(level, new ArrayList<>());
        map.get(level).add(parent);
        traverseAndConnect(parent.left, level + 1, map);
        traverseAndConnect(parent.right, level + 1, map);
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
