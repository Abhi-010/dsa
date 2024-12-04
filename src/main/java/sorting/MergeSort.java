package sorting;

public class MergeSort implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {
        System.out.println("Sorting via Merge Sort : ");
        int n = inputArray.length ;
        return mergeSort(0,n-1,inputArray);
    }

    private int[] mergeSort(int s, int e, int[] A){

        //base condition :
        if(s == e){
            return new int[] {A[s]} ;
        }

        int mid = (s+e)/2 ;
        int[] leftSortedArray = mergeSort(s,mid,A);
        int[] rightSortedArray = mergeSort(mid+1,e,A);
        return merge(leftSortedArray,rightSortedArray);
    }
    private int[] merge(int[] A1,int[] A2){

        int n1 = A1.length ;
        int n2 = A2.length ;
        int [] ans = new int[n1+n2] ;

        int p1 = 0 ;
        int p2 = 0 ;
        int k = 0 ;
        while(p1 < n1 && p2 < n2){
            if(A1[p1] < A2[p2]){
                ans[k] = A1[p1];
                p1++;
                k++;
            }
            else {
                ans[k] = A2[p2];
                p2++;
                k++;
            }
        }
        while(p1 < n1){
            ans[k] = A1[p1];
            p1++;
            k++;
        }
        while(p2 < n2){
            ans[k] = A2[p2];
            k++;
            p2++;
        }
        return ans;
    }
}
