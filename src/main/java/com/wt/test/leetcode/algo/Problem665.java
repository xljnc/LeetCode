package com.wt.test.leetcode.algo;

/**
 * 665. 非递减数列
 * https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * @author 一贫
 * @date 2021/2/7
 */
public class Problem665 {

    public static void main(String[] args) {
        Problem665 problem665 = new Problem665();
        int[] nums = {4, 2, 3};
        boolean result = problem665.checkPossibility(nums);
        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1 || nums.length == 2)
            return true;
        //默认没有改变过
        boolean flag = false;
        //从第二个开始
        for (int i = 1; i < nums.length; i++) {
            //如果不符合非递减
            if (nums[i] < nums[i - 1]) {
                //先判断是否有更改过，如果有直接返回false
                if (!flag) {
                    //如果是下标1，则将下标0的值改为下标1，原则是尽量将需要改变的项往小的改
                    if (i == 1)
                        nums[i - 1] = nums[i];
                        //如果下标i大于等于下标i-2,则将下标i-1改为下标i-2
                    else if (nums[i] >= nums[i - 2])
                        nums[i - 1] = nums[i - 2];
                        //将下标i改为下标i-1
                    else
                        nums[i] = nums[i - 1];
                    //标记为已改过
                    flag = true;
                } else
                    return false;
            }
        }
        return true;
    }


}
