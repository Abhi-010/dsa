package problem_solving.scaler_questions;

import java.util.PriorityQueue;




public class LeetCode_DivideInteger {
    public static void main(String[] args) {

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.val-b.val); // smaller first.
        PriorityQueue<pair> pq2=new PriorityQueue<>((a,b)->b.val-a.val);// larger first.


    }
}

class pair{
    int val;
    int idx;
    pair(int val,int idx){
        this.val=val;
        this.idx=idx;
    }
}


