package problem_solving.scaler_questions;

import java.util.HashMap;

public class MaxXorSubarray {
    public static void main(String[] args) {
        //int[] A = new int[]{15,25,23};
       // int[] A = new int[]{33,29,18};
        //int[] A = new int[]{1,4,3};
        int[] A = new int[]{8};
        int[] ans = solve(A) ;

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }


    public static int[] solve(int[] A) {
        NodeT root = new NodeT() ;
        int n = A.length ;

        //Insert Function  or create a Trie Data Structure :


        int[] PF = new int[n+1] ;
        PF[0] = 0;

        for(int i = 1 ; i < PF.length ; i++){
            PF[i] = PF[i-1] ^ A[i-1] ;
        }
        int m = maxBit(A) ;
        //System.out.println("max bit :" +m);

        //System.out.println("prefix xor : ");
//        for(int i = 0 ; i < PF.length ; i++){
//            System.out.print(PF[i] + " ");
//        }
        //System.out.println();

        for (int j : PF) {
            insert(root, j,m);
        }

        int realAns = Integer.MIN_VALUE ;

        for(int i = 0 ; i < PF.length ; i++){
            realAns = Math.max(realAns,maxXor(root,PF[i],m)) ;
        }
        //System.out.println("real ans :" + realAns);

        int L = -1 ;
        int R = -1 ;

//        for(int i = 0 ; i < n ;i++){
//            if(realAns == PF[i]){
//                L = i ;
//                R = i ;
//            }
//        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(PF[0],0);

        for(int i = 1 ; i < PF.length ; i++){
//            System.out.println("...........");
//            System.out.println("PF[i] " + i + " " + PF[i]);
//            System.out.print("realAns ^ PF[i] : " + i + " " + (realAns^PF[i]) + " ");
//            System.out.println();
            if(!map.containsKey(realAns^PF[i])){
                map.put(PF[i],i);
            }
            else{
                if(L == -1 && R == -1){
                    L = map.get(realAns^PF[i]) ;
                    R = i ;
                }
                else{
                    int L1 = map.get(realAns^PF[i]);
                    int R1 = i ;
                    if((R1-L1) < (R-L)){
                        L = L1 ;
                        R = R1 ;
                    }
                    else if((R1-L1) == (R-L)){
                        if(L1 < L){
                            L = L1 ;
                            R = R1 ;
                        }
                    }
                    map.put(PF[i],i);
                }
            }
//            System.out.println(i + " L : " +  L);
//            System.out.println(i + " R : " +  R);
        }
//        if(L != 0){
//           L=L+1 ;
//        }
        R = R-1 ;
        return new int[]{L+1,R+1} ;
    }


    public static int findMaximumXORPair(int[] A) {
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
        return ans ;
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
