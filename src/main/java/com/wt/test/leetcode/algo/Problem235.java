package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author 一贫
 * @date 2020/9/27
 */
public class Problem235 {
    public static void main(String[] args) {
        Problem235 problem235 = new Problem235();
        Integer[] input = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        TreeNode parent = problem235.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
//        TreeNode parent = problem235.lowestCommonAncestor1(root, new TreeNode(2), new TreeNode(4));
        System.out.println(parent);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                break;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> pathP = findPath(root, p);
        List<Integer> pathQ = findPath(root, q);
        int count = 0;
        while (count < pathP.size() && count < pathQ.size()) {
            if (!pathP.get(count).equals(pathQ.get(count)))
                break;
            count++;
        }
        return new TreeNode(pathP.get(count - 1));
    }

    public List<Integer> findPath(TreeNode root, TreeNode target) {
        TreeNode curr = root;
        List<Integer> path = new ArrayList<>();
        while (curr != null) {
            path.add(curr.val);
            if (curr.val == target.val)
                return path;
            if (target.val > curr.val)
                curr = curr.right;
            else
                curr = curr.left;
        }
        return new ArrayList<>();
    }

}
