package sorting;

public class SelectionSort implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {
        System.out.println("Sorting via Selection sort");
        int n = inputArray.length ;
        for(int i = n-1 ; i >= 0 ; i--){
            int maxIndex = i ;
            int j = i ;
            for( ; j >= 0 ; j--){
                if(inputArray[j] > inputArray[maxIndex]){
                    maxIndex = j ;
                }
            }
            swap(inputArray,maxIndex,i);
        }
        return inputArray ;
    }
    public void swap(int[] A, int maxIndex, int i){
        int max = A[maxIndex];
        A[maxIndex] = A[i];
        A[i] = max ;
    }
}
