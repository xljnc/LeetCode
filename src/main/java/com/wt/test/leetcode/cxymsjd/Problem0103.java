package com.wt.test.leetcode.cxymsjd;

/**
 * 面试题 01.03. URL化
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 *
 * @author 一贫
 * @date 2020/9/22
 */
public class Problem0103 {
    public static void main(String[] args) {
        Problem0103 problem0103 = new Problem0103();
        problem0103.replaceSpaces("Mr John Smith    ", 13);
    }

    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int i = length - 1;
        int j = chars.length - 1;
        while (i >= 0) {
            if (S.charAt(i) != ' ') {
                chars[j--] = S.charAt(i);
            } else {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
            i--;
        }
        return new String(chars, j + 1, S.length() - j - 1);
    }
}
