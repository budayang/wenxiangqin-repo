/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package bytedance;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wenxiangqin
 * @version $Id: LRUCache.java, v 0.1 2022-05-19 4:18 下午 wenxiangqin Exp $$
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> linkedHashMap;

    private int capacity;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<>(capacity);
        capacity = capacity;
    }

    public int get(int key) {
        if (!linkedHashMap.keySet().contains(key)) return -1;
        int value = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (linkedHashMap.keySet().contains(key)) linkedHashMap.remove(key);

        if (capacity == linkedHashMap.size()) {
            Integer value1 = linkedHashMap.entrySet().iterator().next().getValue();
            linkedHashMap.remove(value1);
        }
        linkedHashMap.put(key, value);
    }
}