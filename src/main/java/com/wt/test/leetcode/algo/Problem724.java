package com.wt.test.leetcode.algo;

/**
 * 724. 寻找数组的中心索引
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * @author 一贫
 * @date 2021/1/28
 */
public class Problem724 {

    public static void main(String[] args) {
        Problem724 problem724 = new Problem724();
        int[] nums = {-1, -1, 1, 1, 0, 0};
        int result = problem724.pivotIndex(nums);
        System.out.println(result);
    }

    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        if (count - nums[0] == 0)
            return 0;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr == count - nums[i] - curr)
                return i;
            curr += nums[i];
        }
        return -1;
    }
}
