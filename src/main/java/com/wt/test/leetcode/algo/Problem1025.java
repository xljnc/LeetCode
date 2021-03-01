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
     * 思路：对每个数N，Alice的操作肯定会导致对手的数字为M(M<N)
     * 因此只要判断是否存在一个数字M，导致对手必输即可。
     */
    public boolean divisorGame(int N) {
        boolean[] result = new boolean[N + 2];
        result[1] = false;
        result[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !result[i - j]) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[N];
    }

    /**
     * 思路：根据Alice先手是基数还是偶数。
     * N = 1 时，没有选择，必输
     * N = 2 时，只能选1，对手数字为1，必胜
     * N为奇数时，因子只能是奇数，所以步骤2会导致对手可选的数字肯定是偶数，
     * 对手可以选择因子是奇数还是偶数，因此最后对手可以控制Alice可选的数字最终为1，必输
     * N为偶数时，可以选择因子是奇数还是偶数，所以步骤2会导致对手可选的数字肯定是奇数，
     * 最后对手可以选的数字最终为1，必胜
     */
    public boolean divisorGame1(int N) {
        return N % 2 == 0;
    }
}
