package com.wt.test.leetcode.algo;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author 一贫
 * @date 2020/9/15
 */
public class Problem27 {
    public static void main(String[] args) {
        Problem27 problem27 = new Problem27();
        int[] nums = {3, 3};
        int result = problem27.removeElement(nums, 3);
        System.out.println(result);
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                if (nums[left] == val) {
                    count++;
                    return nums.length - count;
                }
            }
            if (nums[left] != val) {
                left++;
                continue;
            }
            nums[left] = nums[right];
            right--;
            count++;
        }
        return nums.length - count;
    }

}
