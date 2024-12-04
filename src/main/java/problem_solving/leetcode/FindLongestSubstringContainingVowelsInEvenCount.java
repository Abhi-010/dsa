package problem_solving.leetcode;

import java.util.HashMap;

public class FindLongestSubstringContainingVowelsInEvenCount {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
    }

    public static int findTheLongestSubstring(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("00000",-1);
        int[] state = new int[5] ; // a e i o u
        int ans = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                state[0] += 1;
                state[0] %= 2;
            }
            else if(ch == 'e'){
                state[1] += 1;
                state[1] %= 2;
            }
            else if(ch == 'i'){
                state[2] += 1;
                state[2] %= 2;
            }
            else if(ch == 'o'){
                state[3] += 1 ;
                state[3] %= 2 ;
            }
            else if(ch == 'u'){
                state[4] += 1 ;
                state[4] %= 2 ;
            }
            String newState = "";
            for(int j = 0 ; j < 5 ; j++){
                newState = newState + state[0] ;
            }

            System.out.println(i + " : " + newState.toString() );
            if(!map.containsKey(newState)){
                map.put(newState,i);
            }
            else{
                int prevIndex = map.get(newState);
                ans = Math.max(ans,(i-prevIndex));
                System.out.println("ans : " + i + " : " + ans);
                //map.put(newState,i);
            }
        }
        return ans;
    }
}
