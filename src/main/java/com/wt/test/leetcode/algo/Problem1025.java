package com.wt.test.leetcode.algo;

/**
 * 1025. 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/
 *
 * @author 一贫
 * @date 2021/3/1
 */
public class Problem1025 {

    /**
     * 思路：根据Alice先手是基数还是偶数。
     * N = 1 时，没有选择，必输
     * N = 2 时，只能选1，对手数字为1，必胜
     * N为奇数时，因子只能是奇数，所以步骤2会导致对手可选的数字肯定是偶数，
     * 对手可以选择因子是奇数还是偶数，因此最后对手可以控制Alice可选的数字最终为1，必输
     * N为偶数时，可以选择因子是奇数还是偶数，所以步骤2会导致对手可选的数字肯定是奇数，
     * 最后对手可以选的数字最终为1，必胜
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
