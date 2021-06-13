package com.wt.test.leetcode.algo;

/**
 * 278. 第一个错误的版本
 * https://leetcode-cn.com/problems/first-bad-version/
 *
 * @author qiyu
 * @date 2021/6/13
 */
public class Problem278 {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}
