package com.wt.test.leetcode.algo;

/**
 * 5535. 括号的最大嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 *
 * @author qiyu
 */
public class Problem5535 {
    public static void main(String[] args) {
        Problem5535 problem5535 = new Problem5535();
        String s = "(1+(2*3)+((8)/4))+1";
        int result = problem5535.maxDepth(s);
        System.out.println(result);
    }

    public int maxDepth(String s) {
        if (s== null || s == "")
            return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')
                sb.append(s.charAt(i));
        }
        s = sb.toString();
        int count = 0;
        while (s.contains("()")) {
            s = s.replace("()", "");
            count++;
        }
        return count;
    }
}
