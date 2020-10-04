package com.wt.test.leetcode;

/**
 * @author 一贫
 * @date 2020/10/4
 */
public class Problem5533 {
    private int times = 0;

    public static void main(String[] args) {
        Problem5533 problem5533 = new Problem5533();
        int result = problem5533.minimumOneBitOperations(6);
        System.out.println(result);
    }

    public int minimumOneBitOperations(int n) {
        if (n == 0)
            return 0;
        String s = Integer.toBinaryString(n);
        reverse(s, 0);
        return times;
    }

    public void reverse(String s, int curr) {
        if (curr == s.length())
            return;
        if (s.charAt(curr) == '0')
            reverse(s, curr + 1);
        if (curr == s.length() - 1) {
            if (s.charAt(curr) == '1') {
                times++;
                return;
            }
        }
        char[] sc = s.toCharArray();
        if (s.charAt(curr + 1) != '1') {
            if (s.charAt(s.length() - 1) == '0')
                sc[s.length() - 1] = '1';
            else
                sc[s.length() - 1] = '0';
            times++;
        } else {
            boolean flag = true;
            for (int i = curr + 2; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                if (s.charAt(s.length() - 1) == '0')
                    sc[s.length() - 1] = '1';
                else
                    sc[s.length() - 1] = '0';
                times++;
            } else {
                if (s.charAt(curr) == '0')
                    sc[curr] = '1';
                else
                    sc[curr] = '0';
                times++;
                curr++;
            }
        }
        s = new String(sc);
        reverse(s, curr);
    }
}
