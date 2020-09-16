package com.wt.test.leetcode.algo;

/**
 * 8. 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author 一贫
 * @date 2020/9/16
 */
public class Problem8 {
    public static void main(String[] args) {
        Problem8 problem8 = new Problem8();
        System.out.println(problem8.myAtoi("0-1"));
    }

    public int myAtoi(String str) {
        if (str == null || str.equals(""))
            return 0;
        int result = 0;
        int curr = 0;
        boolean negative = false;
        boolean loop = true;
        boolean signDetected = false;
        boolean spaceDetected = false;
        boolean overflow = false;
        do {
            char c = str.charAt(curr);
            if (c == ' ') {
                if (spaceDetected)
                    break;
                continue;
            }
            if (c == '+') {
                if (signDetected)
                    break;
                spaceDetected = true;
                signDetected = true;
                continue;
            }
            if (c == '-') {
                if (signDetected)
                    break;
                spaceDetected = true;
                signDetected = true;
                negative = true;
                continue;
            }
            if (c >= '0' && c <= '9') {
                if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
                    overflow = true;
                    break;
                }
                spaceDetected = true;
                signDetected = true;
                result = result * 10 + (c - '0');
            } else {
                loop = false;
            }
        }
        while (loop && ++curr < str.length());
        if (overflow && negative)
            return Integer.MIN_VALUE;
        if (overflow && !negative)
            return Integer.MAX_VALUE;
        if (!overflow && negative)
            return result * -1;
        return result;
    }
}
