package problem_solving.leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length ;
        if(n==0) return 0 ;

        int p1 = 0 ;
        int p2 = n-1;
        int swappedCount = 0 ;

        while(p1 < p2){
            if(nums[p1] != val){
                p1++;
            }
            else{
                if(nums[p2] != val){
                    nums[p1] = nums[p2];
                    nums[p2] = val ;
                }
                else{
                    p2--;
                }
            }
        }
        int ans = 0 ;
        for(int i = 0 ; i < n ;i++){
            if(nums[i] != val){
                ans++;
            }
            else {
                break ;
            }
        }
        return ans;
    }
}
