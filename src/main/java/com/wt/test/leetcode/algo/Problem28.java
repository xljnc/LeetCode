package com.wt.test.leetcode.algo;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author 一贫
 * @date 2020/9/11
 */
public class Problem28 {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals(""))
            return 0;
        if (haystack == null || haystack.equals("") || haystack.length() < needle.length())
            return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    found = false;
                    break;
                }
            }
            if (found)
                return i;
        }
        return -1;

    }


}
