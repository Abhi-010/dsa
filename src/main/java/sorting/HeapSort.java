package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {

        int n = inputArray.length ;

        for(int i = (n/2-1) ; i >= 0 ; i--){
            heapify(inputArray,n,i);
        }


        Arrays.stream(inputArray).forEach((i)-> System.out.print(i + " "));
        System.out.println();

        for(int i = n-1 ; i > 0 ; i--){

            int temp = inputArray[i] ;
            inputArray[i] = inputArray[0] ;
            inputArray[0] = temp ;
            heapify(inputArray,i,0);
        }
        return inputArray ;

    }

    private void heapify(int[] array, int n , int i ){

        int largest = i ;

        int l = 2*i + 1 ;
        int r = 2*i + 2 ;

        if(l < n && array[l] > array[largest]){
            largest = l ;
        }
        if(r < n  && array[r] > array[largest]){
            largest = r;
        }

        if(largest != i){
            int temp = array[i];
            array[i] = array[largest] ;
            array[largest] = temp ;
            heapify(array,n,largest);
        }
    }


    private void insertIntoHeap(List<Integer> l , int element){

        l.add(element);
        int indexNewElementAdded = l.size()-1;

        //parent index :

        while(indexNewElementAdded > 0){
            int parentIndex = (indexNewElementAdded-1)/2 ;
            //swap :
            if(l.get(parentIndex) > l.get(indexNewElementAdded)){
                int valueAtParentIndex = l.get(parentIndex);
                int valueAtNewIndex = l.get(indexNewElementAdded);

                l.set(parentIndex,valueAtNewIndex);
                l.set(indexNewElementAdded,valueAtParentIndex);

                indexNewElementAdded = parentIndex ;
            }
            else{
                break ;
            }
        }
    }

    private int getMinHeap(List<Integer> l ){
        return l.get(0) ;
    }
}
