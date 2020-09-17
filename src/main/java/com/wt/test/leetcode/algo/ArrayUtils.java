package com.wt.test.leetcode.algo;

/**
 * @author 一贫
 * @date 2020/9/17
 */
public class ArrayUtils {

    public static void printString(int[] input) {
        if (input == null)
            throw new IllegalArgumentException("数组不能为空");
        System.out.println(arrayToString(input));
    }

    public static String arrayToString(int[] input) {
        if (input == null)
            throw new IllegalArgumentException("数组不能为空");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (i != 0)
                sb.append(",");
            sb.append(input[i]);
        }
        return sb.toString();
    }
}
