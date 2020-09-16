package com.wt.test.leetcode.algo;

/**
 * 38. 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @author 一贫
 * @date 2020/9/16
 */
public class Problem38 {
    public static void main(String[] args) {
        Problem38 problem38 = new Problem38();
        System.out.println(problem38.countAndSay(30));
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        return cas(countAndSay(n - 1));
    }

    public String cas(String s) {
        int count = 0;
        char curr = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (curr == s.charAt(i))
                count++;
            else {
                sb.append(count).append(curr);
                curr = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(curr);
        return sb.toString();
    }
}
