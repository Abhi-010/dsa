package problem_solving.scaler_questions;//import java.util.HashMap;
//
//public class Solution {
//    private int capacity ;
//    private HashMap<Integer, NodeT> map = new HashMap<>() ;
//    private Node dummy = new Node(-1,-1);
//    private Node tail = dummy;
//
//    public Solution(int capacity) {
//        this.capacity = capacity ;
//    }
//
//    public int get(int key) {
//        if(map.containsKey(key)){
//           NodeT n = map.get(key);
//           int k2 = n.val ;
//
//           removeFromList(n);
//           insertAtBack(n);
//
//           return k2 ;
//        }
//        return -1 ;
//    }
//
//    public void set(int key, int value) {
//        //cache HIT
//        NodeT newNodeT = new NodeT(key,value);
//        if(map.containsKey(key)){
//            NodeT present_nodeT = map.get(key);
//            //remove this node from DLL
//            removeFromList(present_nodeT);
//            map.put(key, newNodeT);
//            insertAtBack(newNodeT);
//        }
//        //cache MISS
//        else{
//            if(map.size() >= this.capacity){
//                int removeKey = dummy.next.key ;
//                removeFromList(dummy.next);
//                map.remove(removeKey) ;
//            }
//            //create a node and place in the DLL
//            insertAtBack(newNodeT);
//            //put that key,node in the map
//            map.put(key, newNodeT);
//        }
//
////        Node temp = dummy ;
////        while (temp != null){
////            System.out.println("key value in dll " + temp.key +" " + temp.val);
////            temp = temp.next ;
////        }
////
////        System.out.println("next one...");
//    }
//
//    public void removeFromList(NodeT present_nodeT){
//        if(dummy != tail){
//            // only one node
//            if(dummy.next == present_nodeT && dummy.next.next == null){
//                dummy.next = dummy.next.next ;
//                tail = dummy ;
//            }
//            //multiple nodes
//            else{
//                if(present_nodeT == tail){
//                    tail.prev.next = null ;
//                    tail = tail.prev ;
//                }
//                else if(present_nodeT == dummy.next){
//                    dummy.next = present_nodeT.next ;
//                    present_nodeT.next.prev = dummy ;
//                }
//                else{// middle
//                    present_nodeT.prev.next = present_nodeT.next ;
//                    present_nodeT.next.prev = present_nodeT.prev ;
//                }
//            }
//        }
//    }
//    public void insertAtBack(NodeT newNodeT){
//
//        //no node
//        if(dummy == tail){
//            dummy.next = newNodeT;
//            newNodeT.prev = dummy ;
//           // tail = newNode ;
//        }
//        else{
//            tail.next = newNodeT;
//            newNodeT.prev = tail ;
//           // tail = newNode ;
//        }
//        tail = newNodeT;
//    }
//}
//
//
