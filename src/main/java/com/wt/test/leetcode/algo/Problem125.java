package com.wt.test.leetcode.algo;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author 一贫
 * @date 2021/4/20
 */
public class Problem125 {

    public static void main(String[] args) {
        Problem125 problem125 = new Problem125();
        boolean result = problem125.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.equals(""))
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char cl = s.charAt(left);
            if (!Character.isLetterOrDigit(cl)) {
                left++;
                continue;
            }
            char cr = s.charAt(right);
            if (!Character.isLetterOrDigit(cr)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(cl) != Character.toLowerCase(cr))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

}
