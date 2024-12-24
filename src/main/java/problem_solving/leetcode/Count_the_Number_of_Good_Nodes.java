//package problem_solving.leetcode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Count_the_Number_of_Good_Nodes {
//    static int countOfGoodNodes;
//    public static void main(String[] args) {
//       // int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
//        //int[][] edges = {{0,1},{1,2},{2,3},{3,4},{0,5},{1,6},{2,7},{3,8}};
//        //int[][] edges = {{0,1},{1,2},{1,3},{1,4},{0,5},{5,6},{6,7},{7,8},{0,9},{9,10},{9,12},{10,11}};
//        int[][] edges = {{6,0},{1,0},{5,1},{2,5},{3,1},{4,3}};
//        System.out.println(countGoodNodes(edges));
//    }
//    public static  int countGoodNodes(int[][] edges) {
//        int n = edges.length ;
//        HashMap<Integer,Node> map = new HashMap<>();
//        for(int i = 0 ; i < n ; i++){
//            int a = edges[i][0];
//            int b = edges[i][1];
////            Node parent ;
////            Node child ;
//
//            if(!map.containsKey(a)){
//                Node parent = new Node(a);
//                map.put(a,parent);
//
//                Node child = new Node(b);
//                map.put(b,child);
//
//                parent.nodeList.add(child);
//            }
//            else{
//                Node parent = map.get(a);
//                Node child ;
//                if(!map.containsKey(b)){
//                      child = new Node(b);
//                      map.put(b,child);
//                }
//                else{
//                    child = map.get(b);
//                }
//                parent.nodeList.add(child);
//            }
//        }
//        System.out.println(map.size());
//        Node root = map.get(0);
//        fillSize(root);
//        return countOfGoodNodes ;
//    }
//    public static int fillSize(Node temp){
//        //base condition
//        if(temp.nodeList.isEmpty()){
//            countOfGoodNodes++;
//            temp.size = 1 ;
//            return 1;
//        }
//
//        List<Node> childList = temp.nodeList ;
//        int totalSize = 0 ;
//        int prevSize = 0 ;
//        boolean isGoodNode = true;
//
//        for(Node childNode : childList){
//            int size = fillSize(childNode);
//            if(prevSize == 0){
//                prevSize = size ;
//            }
//            else{
//                if(prevSize != size){
//                    isGoodNode = false;
//                }
//            }
//            totalSize+=size ;
//        }
//        if(isGoodNode){
//            countOfGoodNodes++;
//        }
//        temp.size = totalSize+1 ;
//        return totalSize+1 ;
//    }
//}
//
//class Node{
//    int nodeNumber ;
//    int size ;
//    List<Node> nodeList ;
//    public Node(int nodeNumber ){
//        this.nodeNumber = nodeNumber ;
//        nodeList = new ArrayList<>();
//    }
//}
