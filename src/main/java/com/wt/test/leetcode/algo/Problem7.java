package com.wt.test.leetcode.algo;

/**
 * 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author 一贫
 * @date 2020/9/4
 */
public class Problem7 {

    public static void main(String[] args) {
        int result = reverse(120);
        System.out.println(result);
    }

    public static int reverse(int x) {
        if (x == 0)
            return 0;
        if (x < 0) {
            String sx = String.valueOf(x);
            sx = sx.substring(1);
            sx = reverseString(sx);
            if (numberStringStartsWith0(sx))
                sx = sx.substring(1);
            sx = "-" + sx;
            return convert(sx);
        } else {
            String sx = String.valueOf(x);
            sx = reverseString(sx);
            if (numberStringStartsWith0(sx))
                sx = sx.substring(1);
            return convert(sx);
        }
    }

    public static boolean numberStringStartsWith0(String input) {
        return input.charAt(0) == '0';
    }

    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static int convert(String input) {
        try {
            return Integer.valueOf(input);
        } catch (Exception e) {
            return 0;
        }
    }
}
