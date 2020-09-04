package com.wt.test.leetcode.algo;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author 一贫
 * @date 2020/9/4
 */
public class Problem14 {

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int minIndex = 0;
        int minLength = strs[0].length();
        String minString = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minIndex = i;
                minLength = strs[i].length();
                minString = strs[i];
            }
        }
        for (int i = minLength; i > 0; i--) {
            String prefix = minString.substring(0, i);
            boolean isPrefix = true;
            for (int j = 0; j < strs.length; j++) {
                if (j == minIndex)
                    continue;
                if (!strs[j].startsWith(prefix)) {
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix)
                return prefix;
        }
        return "";
    }
}
