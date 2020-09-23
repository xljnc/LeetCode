package com.wt.test.leetcode.cxymsjd;

/**
 * 面试题 01.06. 字符串压缩
 * https://leetcode-cn.com/problems/compress-string-lcci/
 *
 * @author 一贫
 * @date 2020/9/23
 */
public class Problem0106 {
    public static void main(String[] args) {
        Problem0106 problem0106 = new Problem0106();
        String result = problem0106.compressString("aabcccccaaa");
        System.out.println(result);
    }

    public String compressString(String S) {
        if (S == null || S.length() == 0)
            return S;
        char c = ' ';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            if (curr == c)
                count++;
            else {
                if (count != 0) {
                    sb.append(c).append(count);
                }
                c = curr;
                count = 1;
            }
        }
        if (c != ' ')
            sb.append(c).append(count);
        String result = sb.toString();
        return result.length() >= S.length() ? S : result;
    }
}
