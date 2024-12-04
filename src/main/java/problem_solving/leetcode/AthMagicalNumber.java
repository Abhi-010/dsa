package problem_solving.leetcode;

public class AthMagicalNumber {


    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1000000000, 40000, 40000));
    }

    public static int nthMagicalNumber(int n, int a, int b) {
        long N = Math.min(a,b) * (long)n ;
        System.out.println("value of N : " + N );
        // search space = 1 to N
        long i = 1 ;
        long j = N  ;
        int ans = -1 ;
        // LCM of a & b :
        long g = gcd(a,b);
        long lcm = (long)a*b/g ;

        while(i <= j){
            long m = (i+j)/2 ;

            long count = getNumberOfMagicalNumber(m,a,b,lcm);
            // there are 3 cases :
            // case 1 :
            if(count == n){
                ans = (int)(m%1000000007) ;
                j = m-1;
            }
            else if(count < n){
                i = m+1 ;
            }
            else {
                j = m-1 ;
            }
        }
        return ans;
    }

    public static long getNumberOfMagicalNumber(long m , int a, int b ,long lcm){
        return m/a + m/b - m/lcm ;
    }

    public static long gcd(int a, int b){
        if(a == 0) {
            return b ;
        }
        else if(b ==0){
            return a ;
        }
        if(b > a){
            return gcd(a,b%a);
        }
        else if(a >= b){
            return gcd(a%b,b);
        }
        return 1;
    }
}
