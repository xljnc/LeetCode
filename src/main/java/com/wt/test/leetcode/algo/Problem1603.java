package com.wt.test.leetcode.algo;

/**
 * 1603. 设计停车系统
 * https://leetcode-cn.com/problems/design-parking-system/
 *
 * @author 一贫
 * @date 2021/3/19
 */
public class Problem1603 {

    static class ParkingSystem {

        private int[] slot = new int[4];

        public ParkingSystem(int big, int medium, int small) {
            slot[1] = big;
            slot[2] = medium;
            slot[3] = small;
        }

        public boolean addCar(int carType) {
            return slot[carType]-- > 0;
        }

    }
}
