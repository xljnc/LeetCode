package com.wt.test.leetcode.algo;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 *
 * @author 一贫
 * @date 2020/12/10
 */
public class Problem860 {

    public static void main(String[] args) {
        Problem860 problem860 = new Problem860();
        int[] bills = {5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
        boolean result = problem860.lemonadeChange(bills);
        System.out.println(result);
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0)
            return true;
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five < 1)
                    return false;
                ten++;
                five--;
            } else {
                if (five == 0)
                    return false;
                if (ten == 0 && five < 3)
                    return false;
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
        }
        return true;
    }
}
