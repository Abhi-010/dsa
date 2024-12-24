package problem_solving.leetcode;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private HashMap<Integer,Node> map ;
    private Node dummyNode ;
    private Node tail ;

    public LRUCache(int capacity) {
        this.capacity = capacity ;
        dummyNode = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE,null,null);
        tail = dummyNode ;
        map = new HashMap<>() ;

    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1 ;
        }
        else if(map.get(key) != tail){
            Node existNode = map.get(key);
            existNode.prev.next = existNode.next ;
            existNode.next.prev = existNode.prev ;
            tail.next = existNode ;
            tail = tail.next ;
        }
        return tail.value;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value,null,null);
       // Node prevN = tail ;
        if (!map.containsKey(key) && capacity > map.size()) {
            map.put(key,newNode);
            tail.next = newNode ;
            newNode.prev = tail ;
            tail = tail.next ;
        }
        // map.containsKey(key)
        else if(map.containsKey(key)){
            Node existNode = map.get(key);
            if(existNode.next == null){
                tail = tail.prev ;
                existNode.prev.next = null ;

            }
            else{
                existNode.prev.next = existNode.next ;
                existNode.next.prev = existNode.prev ;
            }
            map.put(key,newNode);
            tail.next = newNode ;
            newNode.prev = tail ;
            tail = tail.next ;
        }
        else if(capacity == map.size()){
            map.remove(dummyNode.next.key);
            dummyNode.next = dummyNode.next.next ;
            if(dummyNode.next == null){
                tail = dummyNode ;
            }
            map.put(key,newNode);
            tail.next = newNode ;
            newNode.prev = tail ;
            tail = tail.next ;
        }
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
