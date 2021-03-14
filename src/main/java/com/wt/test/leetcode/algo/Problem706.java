package com.wt.test.leetcode.algo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * https://leetcode-cn.com/problems/design-hashmap/
 *
 * @author qiyu
 * @date 2021/3/14
 */
public class Problem706 {

}

class MyHashMap {

    /**
     * Initialize your data structure here.
     */
    private LinkedList[] data;
    private static final int BASE = 1024;

    public MyHashMap() {
        data = new LinkedList[1024];
        for (int i = 0; i < 1024; i++) {
            data[i] = new LinkedList<Entry>();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = Integer.valueOf(key).hashCode();
        int slot = hash % BASE;
        Iterator<Entry> iterator = data[slot].iterator();
        while (iterator.hasNext()) {
            Entry item = iterator.next();
            if (item.key == key) {
                item.value = value;
                return;
            }
        }
        data[slot].addLast(new Entry(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = Integer.valueOf(key).hashCode();
        int slot = hash % BASE;
        Iterator<Entry> iterator = data[slot].iterator();
        while (iterator.hasNext()) {
            Entry item = iterator.next();
            if (item.key == key) {
                return item.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = Integer.valueOf(key).hashCode();
        int slot = hash % BASE;
        Iterator<Entry> iterator = data[slot].iterator();
        while (iterator.hasNext()) {
            Entry item = iterator.next();
            if (item.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    private class Entry {
        private int key;
        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}