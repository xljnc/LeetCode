package com.wt.test.leetcode.algo;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author 一贫
 * @date 2020/9/9
 */
public class Problem17 {

    private Map<Character, List<Character>> digitMap = new HashMap<>(16);

    {
        digitMap.put('2', Arrays.asList('a', 'b', 'c'));
        digitMap.put('3', Arrays.asList('d', 'e', 'f'));
        digitMap.put('4', Arrays.asList('g', 'h', 'i'));
        digitMap.put('5', Arrays.asList('j', 'k', 'l'));
        digitMap.put('6', Arrays.asList('m', 'n', 'o'));
        digitMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitMap.put('8', Arrays.asList('t', 'u', 'v'));
        digitMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        String digits = "234";
        List<String> result = problem17.letterCombinations(digits);
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        Set<String> result = new HashSet<>();
        for (int i = digits.length() - 1; i >= 0; i--) {
            result = combine(digits.charAt(i), result);
        }
        return new ArrayList<>(result);
    }

    private Set<String> combine(char digit, Set<String> last) {
        List<Character> chars = digitMap.get(digit);
        if (last.isEmpty()) {
            for (char c : chars) {
                last.add(String.valueOf(c));
            }
            return last;
        } else {
            Set<String> curr = new HashSet<>();
            for (char c : chars) {
                for (String s : last) {
                    curr.add(c + s);
                }
            }
            return curr;
        }
    }

}

