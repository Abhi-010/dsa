package problem_solving.scaler_questions;

import java.util.HashSet;
import java.util.Set;

/*class TestPair{
    double val ;
    int i ;
    int j ;
    public TestPair(double val , int i , int j){
        this.val = val ;
        this.i = i ;
        this.j = j ;
    }
}
class PairComparator implements Comparator<TestPair>{
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
}*/
public class Test {
    public static void main(String[] args) {
        Set<P> set = new HashSet<>();
        P p = new P(1,2) ;
        set.add(p);
        System.out.println(set.size());
        set.add(p);
        System.out.println(set.size());
    }
}
class P{
    int i ;
    int j ;
    public P(int i , int j){
        this.i = i ;
        this.j = j ;
    }
}

