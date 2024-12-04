package sorting;

public class QuickSort implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {
        System.out.println("Sorting via Quick Sort");
        int n = inputArray.length ;
        quickSort(0,n-1,inputArray);
        return inputArray;
    }

    private void quickSort(int s , int e, int[] A){
        if(s >= e) return ;
        int m = partition(s,e,A);
        quickSort(s,m-1,A);
        quickSort(m+1,e,A);
    }
    private int partition(int s, int e, int[] A){
        int pivotElement = A[s];
        int p1 = s+1 ;
        int p2 = e ;

        while(p1 <= p2){
           if(A[p1] <= pivotElement) p1++;
           else if(A[p2] > pivotElement) p2--;
           else{
               BubbleSort.swap(A,p1,p2);
               p1++;
               p2--;
           }
        }
        BubbleSort.swap(A,s,p2);
        return p2 ;
    }
}
