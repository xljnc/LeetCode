package com.wt.test.leetcode.algo;

/**
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author qiyu
 */
public class Problem35 {

    public static void main(String[] args) {
        int[] nums = {1,3};

       int result = searchInsert(nums,3);
        System.out.println(result);
    }

    public static  int searchInsert(int[] nums, int target) {
        if(target<=nums[0])
            return 0;
        if(target> nums[nums.length-1])
            return nums.length;
        for(int i=1;i<nums.length;i++){
            if(target<= nums[i])
                return i;
        }
        return nums.length;
    }
}
