package com.wt.test.leetcode.algo;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 *
 * @author 一贫
 * @date 2021/7/5
 */
public class Problem704 {

    public int search(int[] nums, int target) {
        if (nums[0] == target)
            return 0;
        if (nums[nums.length - 1] == target)
            return nums.length - 1;
        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
