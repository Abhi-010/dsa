package problem_solving.scaler_questions;

import java.util.*;

public class FlipKart {
    public static void main(String[] args) {
        int[] A= new int[]{1, 3,1,7,2,7,1,7 ,6,7, 8,3,3,5,4,4, 5};
        int[] B = new int[]{2,4,6,8,4,4,4,11,8,11,8,7,7,7,6,10,4};
        System.out.println(solve(A,B));
    }

    public static int solve(int[] A, int[] B) {
        List<Pair> pairs = new ArrayList<>();
        int n = A.length ;
        for(int i = 0 ; i < n ; i++){
            pairs.add(new Pair(A[i],B[i]));
        }

        Collections.sort(pairs,new sortPair());

        for(Pair p : pairs){
            System.out.print(p.a + " " + p.b + ", ");
        }
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.b > o2.b){
                    return 1;
                }
                else if(o1.b < o2.b){
                    return -1 ;
                }
                else{
                    if(o1.a < o2.a){
                        return -1;
                    }
                    else if(o1.a > o2.a){
                        return 1 ;
                    }
                }
                return 0 ;
            }
        });


        int ans = 0;
        int t = 0 ;
        for(int i = 0 ; i < n ;i++){
            Pair currentPair = pairs.get(i);
            if(t <= currentPair.a - 1){
                ans+=currentPair.b ;
                t++;
                queue.add(currentPair);
            }
            else{
                if(!queue.isEmpty()){
                    Pair p = queue.peek();
                    if(p.b < currentPair.b){
                        ans+= currentPair.b;
                        ans-=p.b;
                        queue.poll();
                        queue.add(currentPair);
                    }
                }
            }
        }
        return ans;
    }

    static class Pair{
        int a;
        int b;
        public Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
        public int getA(){
            return a ;
        }
        public int getB(){
            return b ;
        }
    }


    static class sortPair implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2){
            if(p1.getA() > p2.getA()){
                return 1;
            }
            else if(p1.getA() < p2.getA()){
                return -1;
            }
            else{
                if(p1.getB() < p2.getB()){
                    return 1;
                }
                else if(p1.getB() > p2.getB()){
                    return -1 ;
                }
                //return 0;
            }
            return 0;
        }
    }

}



