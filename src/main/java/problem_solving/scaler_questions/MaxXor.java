package problem_solving.scaler_questions;

public class MaxXor {
    public static void main(String[] args) {
        int[] A = new int[]{33,60,46} ;
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        NodeT root = new NodeT() ;
        int n = A.length ;

        //Insert Function  or create a Trie Data Structure :
        int m = maxBit(A) ;
        for (int j : A) {
            insert(root, j,m);
        }

        int ans = Integer.MIN_VALUE ;

        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, maxXor(root,A[i],m)) ;
        }

        return ans ;
    }
    public static int maxBit(int[] A){
        int maxbit = -1 ;
        for(int i = 0 ; i < A.length ; i++){
            int a = A[i] ;
            int m = -1 ;
            for(int j = 30 ; j >= 0 ; j--){
                if(checkBit(a,j)){
                    m = j ;
                    break ;
                }
            }
            maxbit = Math.max(m,maxbit) ;
        }
        return maxbit ;
    }

    public static int maxXor(NodeT root,int a,int m){
        int ans = 0  ;
        NodeT temp = root ;
        for(int i = m ; i >= 0 ; i--){

            if(checkBit(a,i)){
                if(temp.trie[0] != null){
                    ans = ans + (1<<i) ;
                    temp = temp.trie[0];
                }
                else{
                    temp = temp.trie[1] ;
                }
            }
            else{
                if(temp.trie[1] != null){
                    ans = ans + (1<<i) ;
                    temp = temp.trie[1];
                }
                else{
                    temp = temp.trie[0];
                }
            }
        }
        return Math.max(ans,a) ;
    }


    public static void insert(NodeT root,int a,int m){
        NodeT temp = root ;

        for(int i = m ; i >= 0 ; i--){
            if(checkBit(a,i)){
                if(temp.trie[1] == null){
                    temp.trie[1] = new NodeT() ;
                }
                temp = temp.trie[1] ;
            }
            else{
                if(temp.trie[0] == null){
                    temp.trie[0] = new NodeT();
                }
                temp = temp.trie[0] ;
            }
        }
    }
    public static boolean checkBit(int a , int bitPos){
        return ((a >> bitPos) & 1) == 1;
    }
}

class NodeT {
    NodeT[] trie;
    public NodeT(){
        trie = new NodeT[2];
        // 0 & 1
    }
}

