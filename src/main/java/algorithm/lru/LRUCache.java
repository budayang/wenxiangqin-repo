/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wenxiangqin
 * @version $Id: LRUCache.java, v 0.1 2022-03-11 10:05 上午 wenxiangqin Exp $$
 */
public class LRUCache {

    private Map<Integer, Node> map;

    private DoubleLinkedList list;

    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoubleLinkedList();
        cap = capacity;
    }

    /** 将某个key提升为最近使用的 */
    private void makeRecently(int key) {
        Node node = map.get(key);
        list.remove(node);
        list.addFirst(node);
    }

    /** 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        list.addFirst(node);
        map.put(key, node);
    }

    /** 删除某一个key */
    private void removeKey(int key) {
        Node node = map.get(key);
        map.remove(key);
        list.remove(node);
    }

    /** 删除最久未使用元素 */
    private void removeLeastRecently() {
        Node node = list.removeLast();
        map.remove(node.key);
    }

    /** 根据key查找val */

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).key;
    }

    /** 存放元素 */
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            removeKey(key);
            addRecently(key, val);
            return;
        }
        if (list.size() == cap) {
            removeLeastRecently();
        }
        addRecently(key, val);
    }
}