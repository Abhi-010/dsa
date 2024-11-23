package sorting;

public class Client {
    private static SortingAlgorithm sortingAlgorithm = new SelectionSort() ;
    public static void main(String[] args) {
        //int[] inputArray = new int[]{1,2,3,4,-5} ;
        int[] inputArray = createInputRandomArray(2000) ;
        int[] outputArray = sortingAlgorithm.sort(inputArray) ;

        for(int i = 0 ; i < outputArray.length ; i++){
            System.out.print(outputArray[i] + " ");
        }
    }
    private static int[] createInputRandomArray(int numberOfElements){
        int[] array = new int[numberOfElements];
        for(int i = 0 ; i < numberOfElements ; i++){
            array[i] = (int)(Math.random()*1000) ;
        }
        return array;
    }
}
