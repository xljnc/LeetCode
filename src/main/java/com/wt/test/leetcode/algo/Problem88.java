package com.wt.test.leetcode.algo;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author 一贫
 * @date 2021/4/2
 */
public class Problem88 {

    public static void main(String[] args) {
        Problem88 problem88 = new Problem88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        problem88.merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0)
            nums1 = nums2;
        else if (m != 0 && n != 0) {
            int[] result = new int[m + n];
            int i1 = 0, i2 = 0, i3 = 0;
            while (i1 < m && i2 < n) {
                if (nums1[i1] > nums2[i2]) {
                    result[i3++] = nums1[i1++];
                } else {
                    result[i3++] = nums2[i2++];
                }
            }
            if (i1 == m) {
                for (; i2 < n; i2++) {
                    result[i3++] = nums2[i2];
                }
            } else {
                for (; i1 < m; i1++) {
                    result[i3++] = nums1[i1];
                }
            }
            nums1 = result;
        }

    }

}
