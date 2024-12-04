package problem_solving.scaler_questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BthSmallestFraction {
    public static void main(String[] args) {
            int[] A = new int[]{1, 2, 3, 5} ;
            int[] ans = solve(A,3);
            System.out.println(ans[0]);
            System.out.println(ans[1]);
    }
    public static int[] solve(int[] A, int B) {
        PriorityQueue<TestPair> pq = new PriorityQueue<>(new PairComparator());
        int n = A.length ;
        int k = n-1 ;
        for(int i = 0 ; i < n-1 ; i++){
            pq.add(new TestPair( (double)A[i]/A[k], i, k)) ;
        }

//        while(!pq.isEmpty()){
//            TestPair t = pq.peek() ;
//            System.out.println(t.val);
//            pq.poll() ;
//        }

        int index = 1 ;
        int a_i = -1 ;
        int a_j = -1 ;

        while(!pq.isEmpty() && index <= B){
            if(index == B){
                TestPair p = pq.peek() ;
                a_i = p.i ;
                a_j = p.j ;
                break ;
            }
            else{
                TestPair p = pq.peek();
                int t_i = p.i ;
                int t_j = p.j ;
                System.out.println("debug 1 " + t_i + " " + t_j);
                pq.poll();
                if(t_j != t_i){
                    pq.add(new TestPair( (double)A[t_i]/A[t_j-1], t_i , t_j-1));
                }

            }
            index++;
        }
        return new int[]{A[a_i],A[a_j]} ;
    }
}
class TestPair{
    double val ;
    int i ;
    int j ;
    public TestPair(double val , int i , int j){
        this.val = val ;
        this.i = i ;
        this.j = j ;
    }
}
class PairComparator implements Comparator<TestPair> {
    @Override
    public int compare(TestPair p1, TestPair p2) {
        if(p1.val > p2.val){
            return 1 ;
        }
        else if(p1.val < p2.val){
            return -1 ;
        }
//        else{
//            if(p1.b < p2.b){
//                return 1;
//            }
//            else if(p1.b > p2.b){
//                return -1 ;
//            }
//        }
        return 0 ;
    }
    }
