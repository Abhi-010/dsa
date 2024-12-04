package problem_solving.scaler_questions;

public class Intersecting_Chords {
    public static void main(String[] args) {
        System.out.println(chordCnt(1000));

    }
    public static int chordCnt(int N) {
        if(N==1){
            return 1;
        }
        long[] dp = new long[N+1];
        int mod = 1000000007;
        dp[0] = 1 ;
        dp[1] = 1 ;

        for(int i = 2 ; i <= N ; i++){
            //calcuating dp[i]
            long s = 0 ;
            int k = 0 ;
            for(int j = i-1 ; j >= 0 ; j--){
                s = ( s%mod + (dp[j]%mod * dp[k]%mod)%mod )%mod;
                k++;
            }
            dp[i] = s ;
        }
        return (int)dp[N];
    }
}
