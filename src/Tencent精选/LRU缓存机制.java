package Tencent精选;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WJL
 * @date: 2021/08/12 17:
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 **/

public class LRU缓存机制 extends LinkedHashMap<Integer,Integer> {
    public static void main(String[] args) {
        LRU缓存机制 lru缓存机制 = new LRU缓存机制(5);
        lru缓存机制.put(1,1);
        lru缓存机制.put(2,2);
        lru缓存机制.put(3,3);
        lru缓存机制.put(4,4);
        lru缓存机制.put(6,5);
        lru缓存机制.put(8,4);
        lru缓存机制.put(7,5);
    }

    private int capacity;

    public LRU缓存机制(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}


