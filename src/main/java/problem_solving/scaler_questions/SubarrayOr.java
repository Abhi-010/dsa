package problem_solving.scaler_questions;

import java.util.List;

public class SubarrayOr {
    public static void main(String[] args) {
        int i = 4;
        long a = i;

        System.out.println(a);
        //List<Integer> list = Arrays.asList(7,8,9,10);
        //System.out.println(solve(list));
    }


    public static int solve(List<Integer> A) {
        int mod = 1000000007;
        long n = (long)A.size();

        long numberOfSubarray = (n*(n+1))/2 ;
        long ans = 0;
        for(int i = 0 ; i < 3 ; i++){
            long temp = numberOfSubarray;
            int z = 0 ;
            for(int j = 0 ; j < n ; j++){
                if((A.get(j) & (1<<i)) == 0 ){
                    z++;
                }
                else{
                    //bit is set
                    if(z == 1){
                        temp = temp - 1;
                    }
                    else if(z > 1){
                        temp = (temp%mod - ((long) z *(z+1))%mod /2)%mod ;
                    }
                    z = 0 ;
                }
            }
           // System.out.println("i : " + i + " z : " + z);
           // System.out.println("n " + n);
            if(z == n){
                temp = 0;
            }
            else if(z > 0){
                if(z == 1){
                    temp = temp - 1;

                }
                else if(z > 1){
                    temp = (temp%mod - ((long) z *(z+1))%mod /2)%mod ;
                }
            }
           // System.out.println("i : " + i + " temp : " + temp);
            ans = (ans%mod + (temp%mod *pow(i)%mod)%mod )%mod ;
           // System.out.println("ans : " + ans);
        }
        return (int)ans;
    }

    public static int pow(int i){
        int val = 1;
        while(i > 0){
            val = val* 2 ;
            i--;
        }
        return val ;
    }
}
