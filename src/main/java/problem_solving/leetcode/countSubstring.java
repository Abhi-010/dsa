package problem_solving.leetcode;

public class countSubstring {
    public static void main(String[] args) {
        System.out.println(countKConstraintSubstrings("10101 ", 1));
    }

    public static  int countKConstraintSubstrings(String s, int k) {
        int n = s.length();

        int ans = 0 ;

        for(int i = 0 ; i < n ; i++){
            int ones = 0 ;
            int zeros = 0 ;
            for(int j = i ; j < n ; j++){
                if(s.charAt(j) == 48){
                    zeros++;
                }
                else{
                    ones++;
                }
                if(zeros <= k || ones <= k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
