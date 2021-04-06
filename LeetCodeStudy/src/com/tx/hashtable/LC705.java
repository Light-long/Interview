package com.tx.hashtable;

public class LC705 {
    class MyHashSet {

        boolean[] mySet = null;

        /** Initialize your data structure here. */
        public MyHashSet() {
            mySet = new boolean[1000001];
        }

        public void add(int key) {
            mySet[key] = true;
        }

        public void remove(int key) {
            mySet[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return mySet[key];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

}
