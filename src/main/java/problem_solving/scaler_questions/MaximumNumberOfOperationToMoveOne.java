package problem_solving.scaler_questions;

public class MaximumNumberOfOperationToMoveOne {
    public static void main(String[] args) {
        System.out.println(maxOperations("00111"));
    }

    public static int maxOperations(String s) {
        //reverse string
        int n = s.length() ;
        String reverseString = "";
        for(int i = n-1 ; i >=0 ; i--){
            reverseString = reverseString + s.charAt(i) ;
        }


        // ignore all 1s at the end of String s
        int i = 0 ;
        for( ; i < n ; i++){
            if(reverseString.charAt(i) != '1'){
                break;
            }
        }

        int impact = 1 ;
        int ans = 0 ;
        for(int j = i ; j < n ; j++){
            if(reverseString.charAt(j) == '0'){
                continue;
            }
            int ct = 0 ;
            int k = j ;
            while(k < n && reverseString.charAt(k) == '1'){
                ct++ ;
                k++;
            }
            j = k-1 ;
            ans = ans + (ct*impact);
            impact++;

        }
        return ans;
    }

    public static int maxOperations1(StringBuilder s) {

        int n = s.length() ;
        int ans = 0 ;

        while(true){
            int i = 0;
            for(; i < n-1 ; i++){
                if(s.charAt(i) == '1' && s.charAt(i+1) == '0'){
                    break ;
                }
            }
            if(i == n-2){
                break;
            }
            int j = i ;
            for( ; j < n-1 ; j++){
                if(s.charAt(j) == '0' && s.charAt(j+1) == '1'){
                    break;
                }
            }
            // make s.charAt(i) to 0
            // make s.charAt(j) to 1

            s.setCharAt(i,'0');
            s.setCharAt(j,'1'); ;
            ans = ans + 1 ;
        }
        return ans ;
    }
}
