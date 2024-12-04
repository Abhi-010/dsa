package sorting;

/*
Algorithm	                 Time Complexity	            Space Complexity
                    Best	    Average 	Worst	  Worst
Selection Sort	    O(n2)	    O(n2)	    O(n2)	   O(1)
Bubble Sort	        O(n)	    O(n2)	    O(n2)	   O(1)
Insertion Sort	    O(n)	    O(n2)	    O(n2)	   O(1)
Merge  Sort         O(nlogn)   O(nlogn)     O(nlogn)   0(n)
 */

/*
1. Merge  Sort
2. Quick  Sort
3. Heap   Sort
4. Bucket Sort
 */

public class Client {
    private static SortingAlgorithm sortingAlgorithm = new SelectionSort() ;

    public static void main(String[] args) {

        int[] inputArray = createInputRandomArray(20) ;
        int[] outputArray = sortingAlgorithm.sort(new int[]{-4,10,0,1,-4,23,100,4,-4}) ;

        System.out.println("Selection Sort : ");
        for(int i = 0 ; i < outputArray.length ; i++){
            System.out.print(outputArray[i] + " ");
        }
        System.out.println();

        System.out.println("Bubble Sort : ");
        sortingAlgorithm = new BubbleSort() ;

        inputArray = createInputRandomArray(20);

        outputArray = sortingAlgorithm.sort(new int[]{-4,10,0,1,-4,23,100,4,-4});

        for(int i = 0 ; i < outputArray.length ; i++){
            System.out.print(outputArray[i] + " ");
        }


        sortingAlgorithm = new InsertionSort() ;
        inputArray = createInputRandomArray(20);

        outputArray = sortingAlgorithm.sort(new int[]{-4,-4,0,0});
        //outputArray = sortingAlgorithm.sort(inputArray);
        for(int i = 0 ; i < outputArray.length ; i++){
            System.out.print(outputArray[i] + " ");
        }


        sortingAlgorithm = new MergeSort() ;

        outputArray = sortingAlgorithm.sort(new int[]{1,1,1,1,1,1});
        for (int j : outputArray) {
            System.out.print(j + " ");
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
