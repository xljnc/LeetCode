package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.TreeNode;
import com.wt.test.leetcode.algo.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * @author 一贫
 * @date 2021/4/29
 */
public class Problem3203 {

    public static void main(String[] args) {
        Problem3203 problem3203 = new Problem3203();
        Integer[] input = {1, 2, 3, 4, null, null, 5};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        List<List<Integer>> result = problem3203.levelOrder(root);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque();
        if (root == null)
            return result;
        deque.add(root);
        boolean turn = false;
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode curr = null;
                if (turn) {
                    curr = deque.pollLast();
                    level.add(curr.val);
                    if (curr.right != null)
                        deque.addFirst(curr.right);
                    if (curr.left != null)
                        deque.addFirst(curr.left);
                } else {
                    curr = deque.pollFirst();
                    level.add(curr.val);
                    if (curr.left != null)
                        deque.add(curr.left);
                    if (curr.right != null)
                        deque.add(curr.right);
                }
            }
            result.add(level);
            turn = !turn;
        }
        return result;
    }
}
