package com.wt.test.leetcode.algo;

/**
 * @author 一贫
 * @date 2020/9/24
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    @Override
    public String toString() {
        return new StringBuilder().append(val).append(",").append(super.toString()).toString();
    }

}
