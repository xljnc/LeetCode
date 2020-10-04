package com.wt.test.leetcode.algo;

/**
 * 58. 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 * @author 一贫
 * @date 2020/10/4
 */
public class Problem58 {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s == "" || s == " ")
            return 0;
        int first = -1;
        int last = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (first == -1)
                    continue;
                else {
                    last = i;
                    break;
                }
            }
            if (first == -1)
                first = i;
        }
        return first - last;
    }
}
