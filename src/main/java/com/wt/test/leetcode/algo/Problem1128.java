package com.wt.test.leetcode.algo;

/**
 * 1128. 等价多米诺骨牌对的数量
 * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 *
 * @author 一贫
 * @date 2021/1/26
 */
public class Problem1128 {

    public static void main(String[] args) {
        Problem1128 problem1128 = new Problem1128();
        int[][] dominoes = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        int result = problem1128.numEquivDominoPairs(dominoes);
        System.out.println(result);
    }

    /**
     * 题目假设二位数组的数字都不会大于9，所以(x,y)可以表示为固定的2位数字，
     * 即(x,y) = 10x+y;x< y;
     * 然后用长度100的数组来记录每一对的数量。
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counter = new int[100];
        int result = 0;
        for (int[] item : dominoes) {
            int val = item[0] < item[1] ? item[0] * 10 + item[1] : item[1] * 10 + item[0];
            //这行代码很巧妙，可以理解为新出现的那张牌和原来所有相对的牌都构成一对，所以加上即可
            //否则需要使用公式n*(n-1)/2来累加
            result += counter[val];
            counter[val]++;
        }
        return result;
    }

//    public int numEquivDominoPairs(int[][] dominoes) {
//        List<List<Integer>> candidates = new ArrayList<>();
//        for (int i = 0; i < dominoes.length; i++) {
//            candidates.add(Arrays.asList(dominoes[i][0], dominoes[i][1]));
//        }
//        int result = 0;
//        while (candidates.size() != 0) {
//            Iterator<List<Integer>> it = candidates.iterator();
//            List<Integer> first = it.next();
//            it.remove();
//            boolean added = false;
//            while (it.hasNext()) {
//                List<Integer> curr = it.next();
//                if (curr.equals(first) || Arrays.asList(curr.get(1), curr.get(0)).equals(first)) {
//                    it.remove();
//                    added = true;
//                }
//            }
//            if (added)
//                result++;
//        }
//        return result;
//    }
}
