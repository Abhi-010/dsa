package problem_solving.leetcode;

public class Q_1590 {
    // Make Sum Divisible by P
    public static void main(String[] args) {

        System.out.println(minSubarray(new int[]{4,4,2},7));
    }


    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] pf = new long[n];
        pf[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + (long) nums[i];
        }
        long ts = pf[n - 1];

        //case 1 :

        if ((ts % p) == 0) {
            return 0;
        }
        if (ts < p) {
            return -1;
        }
        long rem = ts % p;

        for (long ele : nums) {
            if ((ele - rem) % p == 0) {
                return 1;
            }
        }

        int size = 2;
        int ans = -1;
        while (size <= n) {
            ans = checkFunction(pf, size, ts, p);
            if (ans != -1 && ans != n) {
                return ans;
            }
            size++;
        }
        if(ans == n) return -1 ;
        return ans;
    }

    public static int checkFunction(long[] pf, int size, long ts, int p) {
        long rem = ts % p;
        int n = pf.length;
        if ((pf[size - 1] - rem) % p == 0) {
            return size;
        }

        for (int k = size; k < n; k++) {
            long s = pf[k] - pf[k - size];
            if ((s - rem) % p == 0) {
                return size;
            }
        }
        return -1;
    }
}

