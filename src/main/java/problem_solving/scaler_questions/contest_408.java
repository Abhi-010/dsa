package problem_solving.scaler_questions;

public class contest_408 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("101101"));
    }

    public static int numberOfSubstrings(String s) {
        int n = s.length();

        int[] pf = new int[n];
        pf[0] = s.charAt(0) - 48;

        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + (s.charAt(i) - 48);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int len = j - i + 1;
                int ones = 0;
                int zeros = 0;

                if (len == 1) {
                    if (s.charAt(j) == '1') {
                        System.out.println("i " + i + " j " + j);
                        count++;
                    }
                } else {
                    if (i == 0) {
                        ones = pf[j];
                    } else {
                        ones = pf[j] - pf[i - 1];
                    }
                    zeros = len - ones;
                    if (ones >= (zeros * zeros)) {
                        System.out.println("i " + i + " j " + j);
                        count++;
                    }
                }

            }
        }
        return count ;
    }
}


