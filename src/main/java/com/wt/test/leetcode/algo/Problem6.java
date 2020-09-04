package com.wt.test.leetcode.algo;

/**
 * 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author 一贫
 * @date 2020/9/4
 */
public class Problem6 {

    public static void main(String[] args) {
        String result = convert("AB", 1);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if (s.length() <= 1 ||numRows <= 1)
            return s;
        int step = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == (numRows - 1)) {
                int loop = 0;
                for (int j = 0; j < s.length(); j += step) {
                    int curr = i + loop++ * step;
                    if (curr >= s.length())
                        break;
                    result.append(s.charAt(curr));
                }
            } else {
                int loop = 0;
                for (int j = 0; j < s.length(); j += step) {
                    int left = i + loop * step;
                    if (left >= s.length())
                        break;
                    result.append(s.charAt(left));
                    loop++;
                    int right = (2 * loop - 1) * step - left;
                    if (right >= s.length())
                        break;
                    result.append(s.charAt(right));
                }
            }
        }
        return result.toString();
    }
}
