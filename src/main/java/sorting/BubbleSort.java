package sorting;

public class BubbleSort implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {
        System.out.println("Sorting Array via Bubble Sort");
        int n = inputArray.length ;
        for(int i = 0 ; i < n ; i++){
           for(int j = 0 ; j < n-1 ; j++){
               if(inputArray[j] > inputArray[j+1]){
                   swap(inputArray,j,j+1);
               }
           }
        }
        return inputArray ;

    }
    public static void swap(int[] tempArray,int s, int d){
        int temp = tempArray[s] ;
        tempArray[s] = tempArray[d];
        tempArray[d] = temp ;
    }
}
