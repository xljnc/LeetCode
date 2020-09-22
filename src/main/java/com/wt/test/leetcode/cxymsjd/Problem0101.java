package com.wt.test.leetcode.cxymsjd;

/**
 * 面试题 01.01. 判定字符是否唯一
 * https://leetcode-cn.com/problems/is-unique-lcci/
 *
 * @author 一贫
 * @date 2020/9/22
 */
public class Problem0101 {

    public static void main(String[] args) {
        Problem0101 problem0101 = new Problem0101();
        String astr = "Aa";
        System.out.println(problem0101.isUnique(astr));
    }

    public boolean isUnique(String astr) {
        if (astr == null || astr.length() <= 1)
            return true;
        long num = 0L;
        for (int i = 0; i < astr.length(); i++) {
            long mask = 1L << (astr.charAt(i) - 'a');
            if ((num & mask) != 0L)
                return false;
            num = num | mask;
        }
        return true;
    }
}
