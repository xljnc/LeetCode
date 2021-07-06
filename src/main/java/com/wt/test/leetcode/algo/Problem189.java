package com.wt.test.leetcode.algo;

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author 一贫
 * @date 2021/7/6
 */
public class Problem189 {

    public static void main(String[] args) {
        Problem189 problem189 = new Problem189();
        int[] nums = {1, 2, 3, 4};
        int k = 2;
        problem189.rotate(nums, k);
        System.out.println(nums);
    }

    public void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        k = k % nums.length;
        int[] result = new int[k];
        System.arraycopy(nums, nums.length - k, result, 0, k);
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        System.arraycopy(result, 0, nums, 0, k);
    }

//    public void rotate(int[] nums, int k) {
//        if (nums.length <= 1)
//            return;
//        k = k% nums.length;
//        for (int i = 0; i < k; i++) {
//            int temp = nums[nums.length - 1];
//            for (int j = nums.length - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = temp;
//        }
//    }
}
