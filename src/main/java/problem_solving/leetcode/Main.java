package problem_solving.leetcode;

public class Main {

    /*
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2],        [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1) ;
        System.out.println(lruCache.get(6));
        System.out.println(lruCache.get(8));
        lruCache.put(12,1);
        System.out.println(lruCache.get(2));
        lruCache.put(15,11);
        lruCache.put(5,2);
        lruCache.put(1,15);
        lruCache.put(4,2);
        System.out.println(lruCache.get(4));
        lruCache.put(15,15);
    }
}
