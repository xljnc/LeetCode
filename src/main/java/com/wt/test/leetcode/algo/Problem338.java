package com.wt.test.leetcode.algo;

/**
 * 338. 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * @author 一贫
 * @date 2021/3/3
 */
public class Problem338 {

    public static void main(String[] args) {
        Problem338 problem338 = new Problem338();
        System.out.println(ArrayUtils.arrayToString(problem338.countBits(5)));
    }

    private int[] result;


    /**
     * 思路就是n的1个数分为2部分
     * 第一部分是不大于n的最大二次幂，这部分都为1
     * 第二部分是n减去大于n的最大二次幂这部分的1的个数
     * 加在一起就是结果
     */
    public int[] countBits(int num) {
        result = new int[num + 1];
        int min = 1;
        for (int i = 1; i <= num; i++) {
            if (i == min * 2)
                min *= 2;
            result[i] = result[i - min] + 1;
        }
        return result;
    }


    /**
     * 思路就是n的1个数分为2部分
     * 第一部分是不大于n的最大二次幂，这部分都为1
     * 第二部分是n减去大于n的最大二次幂这部分的1的个数
     * 加在一起就是结果
     * 至于如何计算不大于n的最大二次幂，请参考JDK11的容量初始化算法，反正我没看懂，JDK8的算法倒是能看懂
     */
    public int[] countBits1(int num) {
        result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int n = minPow(i);
            if (i == n)
                result[i] = 1;
            else
                result[i] = 1 + result[i - n];
        }
        return result;
    }

    /**
     * 计算大于等于n的最小二次幂
     * 没看懂，反正新的HashMap是这么实现的。
     */
    private int maxPow(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    /**
     * 大于等于n的最小二次幂除以2
     */
    private int minPow(int cap) {
        int max = maxPow(cap);
        return max == cap ? cap : max / 2;
    }
}
