package problem_solving.scaler_questions;

public class TusharBirthday {
    public static void main(String[] args) {
        int[] A = {2,3,1,5,4} ;
        int[] B = {3,2,4,1};
        int[] C = {1,2,5,10};
        System.out.println(solve(A,B,C));
    }

    public static int solve(final int[] A, final int[] B, final int[] C) {

        int maxHunger = Integer.MIN_VALUE;
        for(int i = 0 ; i < A.length ; i++){
            maxHunger = Math.max(maxHunger,A[i]);
        }

        int[][] dp = getDpTable(B,C,maxHunger);

        for(int i= 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // N+1 - rows
        // maxHunger+1 - cols
        int rows = dp.length ;
        int ans = 0 ;

        for(int j = 0 ; j < A.length ; j++){
            int val = A[j] ;
            ans = ans + dp[rows-1][val] ;
        }
        return ans;
    }

    public static int[][] getDpTable(int[] B, int[] C, int K){
        int N = B.length;

        int[][] dp = new int[N+1][K+1];

        for(int i = 0 ; i < N+1 ; i++){
            for(int j = 1 ; j < K+1 ; j++){
                dp[i][j] = -1 ;
            }
        }

        int firstPlateCapacity = B[0];
        for(int j = 1 ; j < K+1 ; j++){
            // j is person's capacity
            // i is the first plate
            if(firstPlateCapacity >= j){
                dp[1][j] = C[0] ;
            }
            else{
                int q = j / firstPlateCapacity ;
                int r = j % firstPlateCapacity ;
                if(r != 0){
                    q = q + 1;
                }
                dp[1][j] = q * C[0];
            }
        }

        for(int i = 2 ; i < N+1 ; i++){
            for(int j = 1 ; j < K+1 ; j++){

                //dp[i][j] = Math.min(dp[i-1][j],  (C[i-1] + dp[i][j-B[i-1]]));

                //leave
                dp[i][j] = dp[i-1][j] ;

                //pick
                if(j > B[i-1] ){
                    dp[i][j] = Math.min(dp[i][j],  (C[i-1] + dp[i][j-B[i-1]]));
                }
            }
        }
        return dp;
    }
}
