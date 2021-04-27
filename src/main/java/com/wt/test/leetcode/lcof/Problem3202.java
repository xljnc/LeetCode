package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.TreeNode;
import com.wt.test.leetcode.algo.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 *
 * @author 一贫
 * @date 2021/4/27
 */
public class Problem3202 {

    public static void main(String[] args) {
        Problem3202 problem3202 = new Problem3202();
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        List<List<Integer>> result = problem3202.levelOrder(root);
        System.out.println(result);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        if (root == null)
            return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            result.add(level);
        }
        return result;
    }

}
