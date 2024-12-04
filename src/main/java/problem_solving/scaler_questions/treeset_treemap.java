package problem_solving.scaler_questions;

import java.util.TreeSet;

public class treeset_treemap {
    public static void main(String[] args) {

        TreeSet<Pair1> treeSet = new TreeSet<>();

        treeSet.add(new Pair1(4,1)) ;
        treeSet.add(new Pair1(4,5)) ;
        treeSet.add(new Pair1(10,1)) ;

        treeSet.add(new Pair1(2,0)) ;

        for(Pair1 p : treeSet){
            System.out.println(p.a + " " + p.b);
        }
    }
}

class Pair1 implements Comparable<Pair1>{
    int a ;
    int b ;
    public Pair1(int a , int b){
        this.a = a ;
        this.b = b ;
    }

    @Override
    public int compareTo(Pair1 p) {
        if(this.a > p.a){
            return 1 ;
        }
        else if(this.a < p.a){
            return -1 ;
        }
        else{
            if(this.b < p.b){
                return 1 ;
            }
            else if(this.b > p.b) {
                return - 1;
            }
        }
        return 0 ;
    }
}
