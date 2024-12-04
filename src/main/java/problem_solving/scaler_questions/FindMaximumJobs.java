package problem_solving.scaler_questions;//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class FindMaximumJobs {
//    public static void main(String[] args) {
//
//        int[] A = new int[]{1,5,7,1};
//        int[] B = new int[]{7,8,8,8};
//        System.out.println(solve(A,B));
//
//    }
//
//    public static int solve(int[] A, int[] B) {
//        List<Pair> pairs = new ArrayList<>();
//        int n = A.length ;
//        for(int i = 0 ; i < n ; i++){
//            pairs.add(new Pair(A[i],B[i]));
//        }
//
//
//        Collections.sort(pairs,new sortPair());
//        for(int i = 0 ; i < n  ;i++){
//            System.out.println(pairs.get(i).getA() + " " + pairs.get(i).getB());
//        }
//
//        int ans = 0;
//        for(int i = 0 ; i < n ;i++){
//            //pick ith pair
//            int tempAns = 0;
//            Pair p = pairs.get(i);
//            int prevS = p.getA();
//            int prevE = p.getB();
//            tempAns++;
//
//            for(int j = i+1 ; j < n ; j++){
//                Pair nextP = pairs.get(j);
//                int nextS = nextP.getA();
//                int nextE = nextP.getB();
//                if(nextS >= prevE){
//                    tempAns++;
//                    prevS = nextS;
//                    prevE = nextE;
//                }
//            }
//            ans = Math.max(ans,tempAns);
//        }
//        return ans;
//    }
//
//    static class sortPair implements Comparator<Pair> {
//        public int compare(Pair p1, Pair p2){
//            if(p1.getA() > p2.getA()){
//                return 1;
//            }
//            else if(p1.getA() < p2.getA()){
//                return -1;
//            }
//            else{
//                if(p1.getB() > p2.getB()){
//                    return 1;
//                }
//                else if(p1.getB() < p2.getB()){
//                    return -1 ;
//                }
//                //return 0;
//            }
//            return 0;
//        }
//    }
//}
