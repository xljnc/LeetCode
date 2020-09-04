package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author 一贫
 * @date 2020/9/4
 */
public class Problem13 {
    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() < 1)
            return 0;
        Map<Character, Integer> refer = new HashMap<>(16);
        refer.put('I', 1);
        refer.put('V', 5);
        refer.put('X', 10);
        refer.put('L', 50);
        refer.put('C', 100);
        refer.put('D', 500);
        refer.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean needMinus = false;
            if (i + 1 < s.length())
                 needMinus = minus(s.charAt(i), s.charAt(i + 1));
            sum += (needMinus ? -1 : 1) * refer.get(s.charAt(i));
        }
        return sum;
    }

    public static boolean minus(char left, char right) {
        return (left == 'I' && (right == 'V' || right == 'X')) ||
                (left == 'X' && (right == 'L' || right == 'C')) ||
                (left == 'C' && (right == 'D' || right == 'M'));
    }
}
