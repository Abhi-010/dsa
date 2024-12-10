package problem_solving.leetcode;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,1,1,2,2,2,2}));
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0 ;

            if(nums.length > 0){
                for(int j = 1; j < nums.length ; j++){
                    if(nums[j-1] != nums[j]){
                        nums[k] = nums[j-1] ;
                        k++ ;
                    }
                }
                nums[k] = nums[nums.length - 1] ;
                k++ ;
            }
            return k ;

        }
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < n-1) {
            int uniqueElementIndex = getNextUniqueElementIndex(p2,nums);

            if(p1+1 != uniqueElementIndex) {
                swap(nums, uniqueElementIndex, p1 + 1);
            }
            p1 = uniqueElementIndex ;
            p2 = uniqueElementIndex ;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        return 0 ;
    }

    public static int getNextUniqueElementIndex(int p2, int[] nums) {
        int val = nums[p2];
        int n = nums.length ;
        while (p2 < n && nums[p2] == val) {
            p2++;
        }
        return p2;
    }

    public static void swap(int[] nums, int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp ;
        return ;
    }
}
