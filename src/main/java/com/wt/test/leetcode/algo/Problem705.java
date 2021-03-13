package com.wt.test.leetcode.algo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * https://leetcode-cn.com/problems/design-hashset/
 *
 * @author 一贫
 * @date 2021/3/13
 */
public class Problem705 {
}


class MyHashSet {

    private LinkedList[] data;
    private static final int BASE = 1024;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        data = new LinkedList[1024];
        for (int i = 0; i < 1024; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int hash = Integer.valueOf(key).hashCode();
        int slot = hash % BASE;
        Iterator<Integer> iterator = data[slot].iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item.equals(key))
                return;
        }
        data[slot].addLast(key);
    }

    public void remove(int key) {
        int hash = Integer.valueOf(key).hashCode();
        int slot = hash % BASE;
        Iterator<Integer> iterator = data[slot].iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item.equals(key)) {
                data[slot].remove(item);
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = Integer.valueOf(key).hashCode();
        int slot = hash % BASE;
        Iterator<Integer> iterator = data[slot].iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item.equals(key))
                return true;
        }
        return false;
    }
}