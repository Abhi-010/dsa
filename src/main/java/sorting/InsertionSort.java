package sorting;

public class InsertionSort implements SortingAlgorithm{
    @Override
    public int[] sort(int[] inputArray) {
        System.out.println();
        System.out.println("Insertion Sort : ");

        int n = inputArray.length ;

        for(int i = 1 ; i < n ; i++){
            int k = i;
            int temp = inputArray[k];
            while(k > 0 && inputArray[k-1] > temp){
                inputArray[k] = inputArray[k-1] ;
                k--;
            }
            inputArray[k] = temp ;
        }
        return inputArray;
    }
}
