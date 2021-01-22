package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 *
 * @author 一贫
 * @date 2021/1/22
 */
public class Problem989 {

    public static void main(String[] args) {
        Problem989 problem989 = new Problem989();
        int[] A = {1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3};
        int K = 516;
        List<Integer> result = problem989.addToArrayForm(A, K);
        System.out.println(result);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int kl = 0;
        //计算K的每位数字，存起来
        List<Integer> kd = new ArrayList<>();
        while (K > 0) {
            int last = K % 10;
            kd.add(last);
            K = K / 10;
            kl++;
        }
        //比较A和K的位数，判断需要循环的次数
        int times = Math.max(A.length, kd.size());
        boolean added = false;
        List<Integer> result = new ArrayList<>();
        //加固定次数，如果A和K位数不足，用0代替
        for (int i = 0; i < times; i++) {
            int leftIndex = A.length - i - 1;
            int left = leftIndex < 0 ? 0 : A[leftIndex];
            int right = i >= kd.size() ? 0 : kd.get(i);
            int sum = left + right + (added ? 1 : 0);
            if (sum > 9) {
                sum = sum % 10;
                added = true;
            } else
                added = false;
            result.add(sum);
        }
        if (added)
            result.add(1);
        Collections.reverse(result);
        return result;
    }
}
