package com.wt.test.leetcode.algo;

import java.util.*;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author 一贫
 * @date 2020/10/5
 */
public class Problem18 {

    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = problem18.fourSum(nums, target);
        System.out.println(result);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length <= 3)
            return new ArrayList<>();
        List<Integer> path = null;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                continue;
            if (nums[i] + nums[l - 3] + nums[l - 2] + nums[l - 1] < target)
                continue;
            path = new ArrayList<>(4);
            path.add(nums[i]);
            find(i + 1, nums[i], path, target, result, nums);
        }
        return new ArrayList<>(result);
    }

    public void find(int curr, int sum, List<Integer> path, int target, Set<List<Integer>> result, int[] nums) {
        int l = path.size();
        if (l > 4)
            return;
        if (l == 4) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        int n = nums.length;
        if (n - curr + l < 4)
            return;
        for (int i = curr; i <= (n - 4 + l); i++) {
            int currSum = sum + nums[i];
            for (int j = 1; j <= (3 - l); j++) {
                currSum += nums[i + j];
            }
            if (currSum > target)
                continue;
            currSum = sum + nums[i];
            for (int j = 1; j <= (3 - l); j++) {
                currSum += nums[n - j];
            }
            if (currSum < target)
                continue;
            path.add(nums[i]);
            find(i + 1, sum + nums[i], path, target, result, nums);
            path.remove(path.size() - 1);
        }
    }
}
