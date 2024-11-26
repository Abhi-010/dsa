package sorting;

public class Client {
    private static SortingAlgorithm sortingAlgorithm = new SelectionSort() ;

    public static void main(String[] args) {

        int[] inputArray = createInputRandomArray(20) ;
        int[] outputArray = sortingAlgorithm.sort(new int[]{-4,10,0,1,-4,23,100,4,-4}) ;


        for(int i = 0 ; i < outputArray.length ; i++){
            System.out.print(outputArray[i] + " ");
        }
        System.out.println();

        sortingAlgorithm = new BubbleSort() ;

        inputArray = createInputRandomArray(20);
        outputArray = sortingAlgorithm.sort(new int[]{-4,10,0,1,-4,23,100,4,-4});

        for(int i = 0 ; i < outputArray.length ; i++){
            System.out.print(outputArray[i] + " ");
        }

    }
    private static int[] createInputRandomArray(int numberOfElements){

        int[] array = new int[numberOfElements];

        for(int i = 0 ; i < numberOfElements ; i++){
            array[i] = -(int)(Math.random()*1000) ;
        }
        return array;
    }
}
