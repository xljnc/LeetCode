package com.wt.test.leetcode;

import com.wt.test.leetcode.algo.TreeNode;
import com.wt.test.leetcode.algo.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 一贫
 * @date 2020/10/4
 */
public class Problem5532 {
    public static void main(String[] args) {
        Problem5532 problem5532 = new Problem5532();
        Integer[] input = {5, 4, 2, 3, 3, 7};
        TreeNode root = TreeUtils.arrayLevelToTree(input);
        problem5532.isEvenOddTree(root);
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return true;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        return judge(root, 0, map);
    }

    public boolean judge(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null)
            return true;
        boolean isEven = level % 2 == 0;
        if (isEven && root.val % 2 == 0)
            return false;
        if (!isEven && root.val % 2 != 0)
            return false;
        if (!map.containsKey(level))
            map.put(level, new ArrayList<>());
        List<Integer> levelList = map.get(level);
        if (levelList.isEmpty())
            levelList.add(root.val);
        else {
            int last = levelList.get(levelList.size() - 1);
            if (isEven) {
                if (root.val <= last)
                    return false;
                else
                    levelList.add(root.val);
            } else {
                if (root.val >= last)
                    return false;
                else
                    levelList.add(root.val);
            }
        }
        return judge(root.left, level + 1, map) && judge(root.right, level + 1, map);
    }

}
