package com.wt.test.leetcode.algo;

/**
 * 605. 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/
 *
 * @author 一贫
 * @date 2021/01/01
 */
public class Problem605 {

    public static void main(String[] args) {
        int[] flowerbed = {};
        int n = 0;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] copied = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i++) {
            copied[i + 1] = flowerbed[i];
        }
        int count = 0;
        for (int i = 1; i < copied.length - 1; i++) {
            if (copied[i - 1] == 0 && copied[i] == 0 && copied[i + 1] == 0) {
                copied[i] = 1;
                count++;
            }
            if (count >= n)
                return true;
        }
        return false;
    }
}
