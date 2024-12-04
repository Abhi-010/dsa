package problem_solving.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {
    static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>> list9 = partition("ababb");
        System.out.println(ans.toString());

        //System.out.println(partition("abcbabaaabaa"));
    }

    public static List<List<String>> partition(String s) {

        int n = s.length();
        boolean[][] mat = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == j) {
                    mat[i][j] = true;
                } else if (i < j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i + 1 == j || mat[i + 1][j - 1]) {
                            mat[i][j] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        ArrayList<String> temp = new ArrayList<>();
        getAllPalindromic(s, mat, 0, temp);
        return ans;
    }

    public static void getAllPalindromic(String s, boolean[][] mat, int start, ArrayList<String> temp) {
        //base condition :
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        //main Logic :
        ArrayList<String> l = new ArrayList<>(temp);
        for (int end = start; end < s.length(); end++) {
            if (mat[start][end]) {
                l.add(s.substring(start, end + 1));
                getAllPalindromic(s, mat, end + 1, l);
                l.remove(l.size() - 1);
            }
        }
        return;
    }
}
