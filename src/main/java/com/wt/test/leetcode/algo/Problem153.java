package com.wt.test.leetcode.algo;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author 一贫
 * @date 2021/4/8
 */
public class Problem153 {

    public static void main(String[] args) {
        Problem153 problem153 = new Problem153();
        int[] nums = {3, 4, 5, 1, 2};
        int result = problem153.findMin(nums);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = nums[right];
        int mid = (left + right) / 2;
        while (mid > left && mid < right) {
            if (nums[mid] <= pivot && nums[mid - 1] > pivot)
                return nums[mid];
            else if (nums[mid] > pivot)
                left = mid;
            else
                right = mid;
            mid = (left + right) / 2;
        }
        return Math.min(nums[mid], pivot);
    }
}
