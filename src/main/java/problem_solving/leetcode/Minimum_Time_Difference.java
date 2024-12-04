package problem_solving.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimum_Time_Difference {
    public static void main(String[] args) {
        System.out.println(findMinDifference(List.of("12:12","12:13")));
    }
    public static  int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> min = new ArrayList<>();

        for(String s : timePoints){
            String[] a = s.split(":",0);
            min.add( (60 * Integer.parseInt(a[0])) + Integer.parseInt(a[1]));
        }

        Collections.sort(min);

        System.out.println(min);

        int n = min.size() ;
        int ans = Integer.MAX_VALUE ;
        for(int i = 1 ; i < n ; i++){
            ans = Math.min(ans,(min.get(i) - min.get(i-1))) ;
            System.out.println(ans );
        }
        int cont = (23*60)+60;
        System.out.println(cont);
        int temp = cont - (min.get(n-1) + min.get(0)) ;
        System.out.println( ".." +  temp ) ;
        ans = Math.min( ans, ( cont - (min.get(n-1) + min.get(0))) );
        return ans;
    }
}
