package com.wt.test.leetcode.algo;

/**
 * 5539. 按照频率将数组升序排序
 * https://leetcode-cn.com/contest/biweekly-contest-38/problems/sort-array-by-increasing-frequency/
 *
 * @author qiyu
 */
public class Problem5539 {

    public static void main(String[] args) {
        Problem5539 problem5539 = new Problem5539();
        int[] nums = {1,1,2,2,2,3};
        int[] result = problem5539.frequencySort(nums);
        System.out.println(result);
    }

    public int[] frequencySort(int[] nums) {
        int[] counter = new int[201];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i] + 100] = counter[nums[i] + 100] + 1;
        }
        int curr = 0;
        for (int i = 0; i < counter.length; i++) {
            int min = 101;
            int minI = 0;
            for (int j = 0; j < counter.length; j++) {
                if (counter[j] == 0)
                    continue;
                if (counter[j] <= min) {
                    min = counter[j];
                    minI = j;
                }
            }
            for (int j = 0; j < min; j++) {
                result[curr++] = minI - 100;
            }
            if (curr == nums.length)
                break;
            counter[minI] = 101;
        }
        return result;
    }
}
