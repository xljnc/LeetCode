package com.wt.test.leetcode.algo;

/**
 * 925. 长按键入
 * https://leetcode-cn.com/problems/long-pressed-name/
 *
 * @author 一贫
 * @date 2020/10/21
 */
public class Problem925 {

    public static void main(String[] args) {
        Problem925 problem925 = new Problem925();
        String name = "kikcxmvzi";
        String typed = "kiikcxxmmvvzz";
        boolean result = problem925.isLongPressedName(name, typed);
        System.out.println(result);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() == 0 || typed == null || typed.length() == 0)
            return false;
        if (name.charAt(0) != typed.charAt(0))
            return false;
        int i = 1, j = 1;
        while (j < typed.length()) { //这里不能用while ( i < name.length() && j < typed.length()) ，会导致name匹配完就退出，而不会匹配typed剩余的部分
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (typed.charAt(j) == typed.charAt(j - 1))
                j++;
            else
                return false;
        }
        return i == name.length();
    }

}
