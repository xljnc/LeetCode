package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 *
 * @author 一贫
 * @date 2021/3/23
 */
public class Problem341 {


}


class NestedIterator implements Iterator<Integer> {

    private List<Integer> holder;

    private int index;

    private void traverse(List<NestedInteger> nestedList) {
        nestedList.forEach((x) -> {
            if (x.isInteger())
                holder.add(x.getInteger());
            else
                traverse(x.getList());
        });
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        holder = new ArrayList<>();
        index = 0;
        traverse(nestedList);
    }

    @Override
    public Integer next() {
        return holder.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < holder.size();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();

}