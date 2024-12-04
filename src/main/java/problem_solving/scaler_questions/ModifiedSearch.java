package problem_solving.scaler_questions;

import java.util.HashMap;
import java.util.Map;

public class ModifiedSearch {
    public static void main(String[] args) {
        String[] A = new String[]{"data", "circle", "cricket"};
        String[] B = new String[]{"date", "circel", "crikket", "data", "circl"};

        System.out.println(solve(A,B));
    }

    public static String solve(String[] A, String[] B) {
        int n = A.length;

        Node root = createTrie(A);

        System.out.println("size " + root.hm.size());


        int m = B.length;
        char[] ans = new char[m];

        for(int i = 0 ; i < m ; i++){
            String s = B[i];
            if(checkInTrie(root,s,0,0)){
                ans[i] = '1';
            }
            else{
                ans[i] = '0';
            }
        }
        return new String(ans);
    }

    public static Node createTrie(String[] A){
        int n = A.length;
        Node root = new Node();
        //Node temp = root ;

        for(int i = 0 ; i < n ; i++){
            String str = A[i];
            int len = str.length();
            Node temp = root ;
            for(int j = 0 ; j < len ; j++){
                char ch = str.charAt(j);
                if(!temp.hm.containsKey(ch)){
                    temp.hm.put(ch,new Node());
                }
                temp = temp.hm.get(ch);
                if(j == len-1){
                    temp.isEnd = true;
                }
            }
        }
        return root ;
    }

    public static boolean checkInTrie(Node root,String s,int flag,int i){

        //base condition :

        if(flag > 1){
            return false;
        }

        if(root.isEnd && flag == 1){
            return true;
        }
        if(i == s.length()){
            return false;
        }
        //main logic :
        HashMap<Character,Node> map = root.hm;
        boolean found1 = false;
        boolean found2 = false;

        for(Map.Entry<Character,Node> mapElement : map.entrySet()){
            Character ch = mapElement.getKey();
            Node nextNode = mapElement.getValue();
            if(ch == s.charAt(i)){
                found1 = checkInTrie(nextNode,s,flag,i+1);
            }
            else{
                found2 = checkInTrie(nextNode,s,flag+1,i+1);
            }
        }
        return (found1 || found2);
    }

}

class Node{
    HashMap<Character,Node> hm;
    boolean isEnd ;
    public Node(){
        hm = new HashMap<>();
        this.isEnd = false;
    }
}

