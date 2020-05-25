package MayPratise;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LRUCache
 * Description: 这题的精髓在于如果知道链表的位置，那么插入和删除的操作的时间复杂度可以降到1
 * 使用hash表快速定位来获取某个链表节点。然后巧妙的利用链表的位置表示访问的次序。
 * 每次访问一个节点分两种情况，首先使用hashmap快速定位一下如果是一开始没有，就添加到头部。首先保证的是这里的大小不超限，如果超限了那么删除尾部的节点。
 * 如果有，那么先删除，然后使用添加头节点上。
 * 由于有头尾指针，插入和删除的操作都是O(1)的。
 * date: 2020/5/25 9:46
 *
 * @author liyh
 */
public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
    }
}
class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node =  cache.get(key);
        if(node == null){
            return -1;
        }
        moveTohead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode nNode = new DLinkedNode(key, value);
            cache.put(key, nNode);
            addToHead(nNode);
            ++size;
            if(size > capacity){
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }
        else{
            node.value = value;
            moveTohead(node);
        }
    }
    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveTohead(DLinkedNode node){
        removeNode(node);
        addToHead(head);
    }
    private DLinkedNode removeTail(){
        DLinkedNode ans = tail.prev;
        removeNode(ans);
        return ans;
    }
}
