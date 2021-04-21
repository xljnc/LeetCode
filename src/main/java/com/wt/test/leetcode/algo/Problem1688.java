package com.wt.test.leetcode.algo;

/**
 * 1688. 比赛中的配对次数
 * https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 *
 * @author 一贫
 * @date 2021/4/21
 */
public class Problem1688 {

    public static void main(String[] args) {
        Problem1688 problem1688 = new Problem1688();
        int result = problem1688.numberOfMatches(14);
        System.out.println(result);
    }

    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 0) {
            if (n == 1)
                break;
            count += n / 2;
            if (n % 2 == 0)
                n = n / 2;
            else
                n = n / 2 + 1;
        }
        return count;
    }
}
