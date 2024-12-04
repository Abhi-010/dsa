package problem_solving.leetcode.contest_17nov;

public class ArrayEqualZero {
    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[]{0}));
    }

    public static int countValidSelections(int[] nums) {
        int ans = 0 ;
        // 1 0 2 0 3
        // 1 1 3 3 6
        // 6 5 5 3 3
        int n = nums.length ;
        if(n==1 && nums[0]==0){
            return 2 ;
        }
        int[] pf_left = new int[n]  ;
        int[] pf_right = new int[n] ;

        // left to right prefix sum :
        pf_left[0] = nums[0] ;
        for(int i = 1 ; i < n ; i++){
           pf_left[i] = pf_left[i-1] + nums[i];
        }

        // right to left prefix sum :
        pf_right[n-1] = nums[n-1] ;
        for(int i = n-2 ; i >= 0 ; i--){
            pf_right[i] = pf_right[i+1] + nums[i] ;
        }

        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                if(pf_left[i] == 0 && pf_right[i+1] == 1){
                    ans+=1 ;
                }
            }
            else if(i == n-1){
                if(pf_right[i] == 0 && pf_left[i-1] == 1){
                    ans+=1 ;
                }
            }
            else{
                if(nums[i] == 0 ){
                    if(pf_left[i-1] == pf_right[i+1]){
                        ans+=2;
                    }
                    else if(Math.abs(pf_left[i-1] - pf_right[i+1]) == 1){
                        ans+=1 ;
                    }
                }
            }
        }
        return ans ;
    }
}
