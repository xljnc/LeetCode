package com.wt.test.leetcode.lcof;

import com.wt.test.leetcode.algo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * @author 一贫
 * @date 2021/4/28
 */
public class Problem3201 {

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        int[] arr = new int[result.size()];
        int i = 0;
        for (Integer item : result) {
            arr[i++] = item;
        }
        return arr;
    }
}
