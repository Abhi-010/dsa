package sorting;

public class SelectionSort implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {
        System.out.println("Sorting via Selection sort");
        int n = inputArray.length ;

        for(int i = n-1 ; i >= 0 ; i--){

            int replaceIndex = i ;
            int maxIndex = i ;
            for(int j = i ; j >= 0 ; j--){
                if(inputArray[j] > inputArray[maxIndex]){
                    maxIndex = j ;
                }
            }
            int temp = inputArray[replaceIndex];
            inputArray[replaceIndex] = inputArray[maxIndex] ;
            inputArray[maxIndex] = temp ;
        }
        return inputArray ;
    }
}
