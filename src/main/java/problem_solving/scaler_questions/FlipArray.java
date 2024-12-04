package problem_solving.scaler_questions;

public class FlipArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{8,4,5,7,6,2}));
    }
    public static int solve(final int[] A) {
        int N = A.length;
        int s = 0 ;
        for(int i = 0 ; i < N ;i++){
            s+=A[i];
        }
        int M = s/2;
        PairFlip[][] dp = new PairFlip[N+1][M+1];

        PairFlip p = new PairFlip(0,0);

        for(int c = 0 ; c <= M  ; c++){
            dp[0][c] = p ;
        }
        for(int r = 0 ; r <= N  ; r++){
            dp[r][0] = p ;
        }

        for(int r = 1 ; r <= N ; r++){
            for(int c = 1 ; c <= M ; c++){
                if(A[r-1] > c){
                    dp[r][c] = new PairFlip(dp[r-1][c].aggregateSum,dp[r-1][c].itemsPicked);
                }
                else{
                    //leave :
                    PairFlip p1 = dp[r-1][c];

                    //pick :
                    PairFlip tempPairFlip = dp[r-1][c-A[r-1]] ;

                    PairFlip p2 =
                            new PairFlip( A[r-1] + tempPairFlip.aggregateSum, 1+ tempPairFlip.itemsPicked);

                    if(p1.aggregateSum == p2.aggregateSum){
                        if(p1.itemsPicked < p2.itemsPicked){
                            dp[r][c] = new PairFlip(p1.aggregateSum,p1.itemsPicked);
                        }
                        else{
                            dp[r][c] = new PairFlip(p2.aggregateSum,p2.itemsPicked);
                        }
                    }
                    else{
                        if(p1.aggregateSum > p2.aggregateSum){
                            dp[r][c] = new PairFlip(p1.aggregateSum,p1.itemsPicked);
                        }
                        else{
                            dp[r][c] = new PairFlip(p2.aggregateSum,p2.itemsPicked);
                        }
                    }
                }
            }
        }

//        for(int r = 0 ; r <= N ; r++){
//            for(int c = 0 ; c <= M ; c++){
//                p = dp[r][c] ;
//                System.out.print(p.aggregateSum + " " + p.itemsPicked + " ");
//            }
//            System.out.println();
//        }
        return dp[N][M].itemsPicked;
    }
}

class PairFlip {
    int aggregateSum ;
    int itemsPicked ;
    public PairFlip(int aggregateSum, int itemsPicked){
        this.aggregateSum = aggregateSum ;
        this.itemsPicked = itemsPicked ;
    }
}
