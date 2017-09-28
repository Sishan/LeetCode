/*
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

class LFUCache {
    class Node{
        public int count;
        public LinkedHashSet<Integer> keys;
        public Node prev, next;
        
        public Node(int count){
            this.count = count;
            keys = new LinkedHashSet<Integer>();
            prev = next = null;
        }
    }
    
    
    private Node head;
    private int cap;
    private HashMap<Integer, Integer> valueHash;
    private HashMap<Integer, Node> nodeHash;
    
    public LFUCache(int capacity) {
        this.cap = capacity;
        valueHash = new HashMap<Integer, Integer>();
        nodeHash = new HashMap<Integer, Node>();
    }
    
    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } 
        else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } 
        else {
            head.keys.add(key);
        }
        nodeHash.put(key, head);      
    }
    
    private void increaseCount(int key){
        Node node = nodeHash.get(key);
        node.keys.remove(key);
        
        if (node.next == null){
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        }
        else if (node.next.count == node.count + 1){
            node.next.keys.add(key);
        }
        else{
            Node tmp = new Node(node.count + 1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }
        
        nodeHash.put(key, node.next);
        if (node.keys.size() == 0) remove(node);
    }
    
    private void remove(Node node){
        if (node.prev == null){
            head = node.next;
        }
        else{
            node.prev.next = node.next;
        }
        if (node.next != null){
            node.next.prev = node.prev;
        }
    }
    
    public void removeOld(){
        if (head == null) return;
        int old = 0;
        for (int n : head.keys){
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) remove(head);
        nodeHash.remove(old);
        valueHash.remove(old);
    }
    
    public int get(int key) {
        if (valueHash.containsKey(key)) {
            increaseCount(key);
            return valueHash.get(key);
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if ( cap == 0 ) return;
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if (valueHash.size() < cap) {
                valueHash.put(key, value);
            } 
            else {
                removeOld();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */