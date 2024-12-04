package problem_solving.scaler_questions;

public class Rearrange_Array {
    public static void main(String[] args) {

        int[] A = new int[]{4, 0, 3, 1, 2};

        int N = A.length ;

        for(int i = 0 ; i < A.length ; i++){
            System.out.print(A[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < A.length ; i++){
            A[i] = A[i] + (A[A[i]] % N) * N ;
            System.out.print(A[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < N ; i++){
            System.out.print(A[i] / N + " " );
        }
        System.out.println();
        for(int i = 0 ; i < N ; i++){
            System.out.print(A[i] % N + " ");
        }
    }


}
