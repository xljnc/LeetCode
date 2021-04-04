package com.wt.test.leetcode.algo;

import java.math.BigInteger;

/**
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 *
 * @author qiyu
 * @date 2021/4/4
 */
public class Problem67 {

    public static void main(String[] args) {
        Problem67 problem67 = new Problem67();
        String a = "1010";
        String b = "1011";
        String s = problem67.addBinary(a, b);
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        if (la != lb) {
            int dis = Math.abs(la - lb);
            if (la > lb) {
                StringBuilder s1 = new StringBuilder();
                for (int i = 0; i < dis; i++) {
                    s1.append("0");
                }
                b = s1.toString() + b;
            } else {
                StringBuilder s1 = new StringBuilder();
                for (int i = 0; i < dis; i++) {
                    s1.append("0");
                }
                a = s1.toString() + a;
            }
        }
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for (int i = Math.max(la, lb) - 1; i >= 0; i--) {
            int ia = Integer.valueOf(String.valueOf(a.charAt(i)));
            int ib = Integer.valueOf(String.valueOf(b.charAt(i)));
            int count = ia + ib + carrier;
            if (count >= 2) {
                count = count - 2;
                carrier = 1;
            } else
                carrier = 0;
            sb.insert(0, count);
        }
        if (carrier == 1)
            sb.insert(0, "1");
        return sb.toString();
    }

    public String addBinary1(String a, String b) {
        return (new BigInteger(a, 2).add(new BigInteger(b, 2))).toString(2);
    }
}
