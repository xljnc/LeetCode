package com.wt.test.leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author 一贫
 * @date 2020/10/2
 */
public class Problem771 {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i)))
                count++;
        }
        return count;
    }
}
