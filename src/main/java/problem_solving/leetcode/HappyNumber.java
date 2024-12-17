package problem_solving.leetcode;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        //set.add(n);
        return isHappyRecur(n,set);
    }

    public static boolean isHappyRecur(int n, HashSet<Integer> set){

        int temp = 0 ;
        while(n > 0){
            int r = n%10;
            n = n/10;
            temp = temp + (r*r) ;
        }
        int temp1 = temp ;
        int a = 0 ;
        while(temp1 > 0){
            int r = temp1 % 10 ;
            temp1 = temp1/10 ;
            a = a + (r*r);
        }
        if(a == 1){
            return true;
        }
        if(set.contains(n)){
            return false ;
        }
        set.add(temp);
        return isHappyRecur(temp,set);
    }

}
