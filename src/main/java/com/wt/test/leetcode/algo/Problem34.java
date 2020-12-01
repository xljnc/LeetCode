package com.wt.test.leetcode.algo;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author 一贫
 * @date 2020/12/1
 */
public class Problem34 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        int target = 4;
        Problem34 problem34 = new Problem34();
        int[] result = problem34.searchRange(nums, target);
        System.out.println(ArrayUtils.arrayToString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length < 3) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (result[0] == -1)
                        result[0] = i;
                    else
                        result[1] = i;

                } else if (nums[i] > target)
                    break;
            }
        } else {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (nums[mid] == target)
                    break;
                else if (nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int i = mid; i >= 0; i--) {
                if (nums[i] == target) {
                    result[0] = i;
                } else if (nums[i] < target)
                    break;
            }
            for (int i = mid; i < nums.length; i++) {
                if (nums[i] == target) {
                    result[1] = i;
                } else if (nums[i] > target)
                    break;
            }
        }
        if (result[0] == -1 && result[1] != -1)
            result[0] = result[1];
        if (result[1] == -1 && result[0] != -1)
            result[1] = result[0];
        return result;
    }
}
