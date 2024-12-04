package problem_solving.scaler_questions;

public class divisor {
    public static void main(String[] args) {
        System.out.println(nonSpecialCount(1000000000,1000000000));
        System.out.println((int)Math.sqrt(2));

        System.out.println('0'-48);

    }

    public static int nonSpecialCount(int l, int r) {
        int countTotNum = (r-l+1) ;
        int countSpecial = 0 ;

        int sqroot = (int) Math.sqrt(l);

        for(int i = sqroot ; i <= r ; i++){
            if(i*i > r){
                break ;
            }
            if(i*i >= l && i*i <= r){
                if(isPrime(i)){
                    countSpecial++  ;
                }
            }
            // check if a number is prime or not
            // square of prime number in in the range of l to r or not
            // if(isPrime(i)){
            //     long sq = (long)i*i ;
            //     if(sq >= l && sq <= r){
            //         countSpecial++ ;
            //     }
            // }
        }
        return countTotNum - countSpecial ;
    }
    public static boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2 ; i*i <= num ; i++){
            if(num%2 == 0){
                return false ;
            }
        }
        return true ;
    }
}
