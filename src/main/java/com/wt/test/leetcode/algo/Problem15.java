package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author 一贫
 * @date 2020/9/4
 */
public class Problem15 {


    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        Problem15 problem15 = new Problem15();
        List<List<Integer>> result = problem15.threeSum(nums);
        System.out.println(result);
    }

    /**
     * 思路:
     * 1.额外判断
     * 2.排序
     * 3.对数组遍历，如果当前值和上个值相同，跳过。
     * 4.使用2个指针，left为左界，right为右。计算三个值的和是否为0，如果是，则加入结果集。
     * 如果小于0，左指针右移。如果大于0，右指针左移。左右指针的移动都需要判断是否等于上个位置的值。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp < 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        List<Integer> temp = new ArrayList<>(3);
        List<List<Integer>> result = new ArrayList<>();
        deep1(0, 0, temp, result);
        return result;
    }

    /**
     * 超时
     */
    public void deep1(int sum, int index, List<Integer> temp, List<List<Integer>> result) {
        if (sum > 0)
            return;
        if (temp.size() == 3 && sum != 0)
            return;
        if (sum == 0 && temp.size() == 3) {
            if (!result.contains(temp))
                result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < this.nums.length; i++) {
            int sumTemp = sum + this.nums[i];
            if (sumTemp > 0)
                return;
            temp.add(this.nums[i]);
            deep1(sumTemp, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    private int[] nums;

}
