package com.wt.test.leetcode.algo;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author 一贫
 * @date 2020/9/15
 */
public class Problem9 {
    public static void main(String[] args) {
        Problem9 problem9 = new Problem9();
        int x = 121;
        System.out.println(problem9.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int rev = 0;
        int temp = x;
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev == x;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        if (x <= 9 && x >= 0)
            return true;
        String value = String.valueOf(x);
        for (int i = 0; i < (value.length() / 2 + 1); i++) {
            if (value.charAt(i) != value.charAt(value.length() - 1 - i))
                return false;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0)
            return false;
        if (x <= 9 && x >= 0)
            return true;
        int count = 0;
        int copy = x;
        while (copy > 0) {
            count++;
            copy = copy / 10;
        }
        for (int i = 0; i < (count / 2 + 1); i++) {
            int div = (int) (x / Math.pow(10, i + 1));
            int low = (x - (int) (div * Math.pow(10, i + 1))) / (int) Math.pow(10, i);

            div = (int) (x / Math.pow(10, count - i));
            int high = (x - (int) (div * Math.pow(10, count - i))) / (int) Math.pow(10, count - i - 1);
            if (low != high)
                return false;
        }
        return true;
    }
}
