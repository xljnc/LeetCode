package com.wt.test.leetcode.algo;

/**
 * 12. 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 *
 * @author 一贫
 * @date 2020/9/7
 */
public class Problem12 {
    public static void main(String[] args) {
        int input = 58;
        System.out.println(intToRoman(input));
    }

    public static String intToRoman(int num) {
        int[] digits = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            while (num >= digits[i]) {
                sb.append(strs[i]);
                num -= digits[i];
            }
        }
        return sb.toString();
    }
}
