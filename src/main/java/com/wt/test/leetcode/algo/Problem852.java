package com.wt.test.leetcode.algo;

/**
 * 852. 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * @author 一贫
 * @date 2021/6/15
 */
public class Problem852 {

    public static void main(String[] args) {
        Problem852 problem852 = new Problem852();
        int[] arr = {0, 1, 0};
        int result = problem852.peakIndexInMountainArray(arr);
        System.out.println(result);
    }


    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
                ans = mid;
            } else
                left = mid + 1;
        }
        return ans;
    }
}
