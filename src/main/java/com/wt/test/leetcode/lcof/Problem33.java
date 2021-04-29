package com.wt.test.leetcode.lcof;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * @author 一贫
 * @date 2021/4/29
 */
public class Problem33 {

    public static void main(String[] args) {
        Problem33 problem33 = new Problem33();
        int[] postorder = {1, 2, 5, 10, 6, 9, 4, 3};
        System.out.println(problem33.verifyPostorder(postorder));
    }

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] postorder, int left, int right) {
        if (left >= right)
            return true;
        int root = postorder[right];
        int point = left;
        while (postorder[point] < root)
            point++;
        for (int i = point + 1; i <= right - 1; i++) {
            if (postorder[i] < root)
                return false;
        }
        return verify(postorder, left, point - 1) && verify(postorder, point, right - 1);
    }

    public boolean verifyPostorder1(int[] postorder) {
        if (postorder == null || postorder.length <= 1)
            return true;
        int root = postorder[postorder.length - 1];
        int point = -1;
        for (int i = 0; i < postorder.length - 1; i++) {
            if (postorder[i] > root) {
                point = i;
                break;
            }
        }
        if (point == -1) {
            int[] left = new int[postorder.length - 1];
            System.arraycopy(postorder, 0, left, 0, left.length);
            return verifyPostorder(left);
        } else {
            for (int i = point; i < postorder.length - 1; i++) {
                if (postorder[i] < root)
                    return false;
            }
            int[] left = new int[point];
            System.arraycopy(postorder, 0, left, 0, left.length);
            int[] right = new int[postorder.length - point - 1];
            System.arraycopy(postorder, point, right, 0, right.length);
            return verifyPostorder(left) && verifyPostorder(right);
        }
    }
}
