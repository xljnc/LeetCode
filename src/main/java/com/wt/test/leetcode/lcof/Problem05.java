package com.wt.test.leetcode.lcof;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author 一贫
 * @date 2020/10/5
 */
public class Problem05 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

}
