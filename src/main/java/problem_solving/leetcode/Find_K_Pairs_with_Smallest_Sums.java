package problem_solving.leetcode;

import java.util.*;

public class Find_K_Pairs_with_Smallest_Sums {
    public static void main(String[] args) {
        kSmallestPairs(new int[] {1,7,11},new int[]{2,4,6},3);
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length ;
        int n2 = nums2.length ;

        HashSet<String> set = new HashSet<>();
        Queue<Triplet> minHeap = new PriorityQueue<>(
                (t1,t2) ->
                {
                    if(t1.sum > t2.sum){
                        return -1 ;
                    }
                    return 1 ;
                }
        );

        int i1 = 0 ;
        int i2 = 0 ;

        Triplet t = new Triplet(i1,i2,nums1[i1]+nums2[i2]);
        minHeap.add(t) ;
        set.add(i1 + "," + i2);

        List<List<Integer>> ans = new ArrayList<>();

        while(!minHeap.isEmpty()){

            if(ans.size() == k){
                break ;
            }

            Triplet triplet = minHeap.poll();

            int indexOfNums1 = triplet.index1;
            int indexOfNums2 = triplet.index2 ;

            List<Integer> tempList = new ArrayList<>();
            tempList.add(nums1[indexOfNums1]) ;
            tempList.add(nums2[indexOfNums2]) ;
            ans.add(tempList);


            // 1. indexOfNums1 , indexOfNums2+1
            // 2. indexOfNums1+1, indexOfNums2

            indexOfNums2++;
            if(!set.contains(indexOfNums1 + "," + indexOfNums2)){
                if(indexOfNums2 < n2){
                    // insert to min Heap
                    triplet = new Triplet(indexOfNums1,indexOfNums2,nums1[indexOfNums1] + nums2[indexOfNums2]);
                    minHeap.add(triplet);
                    set.add(indexOfNums1 + "," + indexOfNums2) ;
                }
            }
            indexOfNums2-- ;
            indexOfNums1++ ;

            if(!set.contains(indexOfNums1 + "," + indexOfNums2)){
                if(indexOfNums1 < n1){
                    triplet = new Triplet(indexOfNums1,indexOfNums2,nums1[indexOfNums1] + nums2[indexOfNums2]);
                    set.add(indexOfNums1 + "," + indexOfNums2) ;
                }
            }
        }
        return ans ;
    }
}

class Triplet{
    int index1 ;
    int index2 ;
    int sum   ;
    public Triplet(int index1, int index2, int sum) {
        this.index1 = index1 ;
        this.index2 = index2 ;
        this.sum = sum  ;
    }
}
