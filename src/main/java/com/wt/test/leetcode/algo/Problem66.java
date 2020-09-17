package com.wt.test.leetcode.algo;

/**
 * 66. 加一
 * https://leetcode-cn.com/problems/plus-one/
 *
 * @author 一贫
 * @date 2020/9/17
 */
public class Problem66 {
    public static void main(String[] args) {
        Problem66 problem66 = new Problem66();
        int[] input = {8, 9, 9, 9};
        input = problem66.plusOne(input);
        System.out.println(ArrayUtils.arrayToString(input));
    }

    public int[] plusOne(int[] digits) {
        boolean addOne = false;
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            addOne = i == digits.length - 1 ? true : false;
            int after = digits[i] + (addOne ? 1 : 0) + (carry ? 1 : 0);
            digits[i] = after % 10;
            if (after > 9)
                carry = true;
            else
                carry = false;
        }
        if (!carry)
            return digits;
        int[] newOne = new int[digits.length + 1];
        newOne[0] = 1;
        System.arraycopy(digits, 0, newOne, 1, digits.length);
        return newOne;
    }
}
