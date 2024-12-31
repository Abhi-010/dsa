package problem_solving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak() ;
        List<String> wordDict = List.of("a","az","b");
        System.out.println(wordBreak.wordBreak("aazaabb", wordDict));
    }


    private Boolean[] t ;
    int n ;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        t = new Boolean[n];
        return solve(s,0,wordDict);
    }
    public boolean solve(String s, int idx, List<String> wordDict){
        if(idx == s.length()){
            return true;
        }
        if(t[idx] != null){
            return t[idx];
        }

        for(int endIdx = idx+1 ; endIdx <= n ; endIdx++){
            String split = s.substring(idx,endIdx);

            if(wordDict.contains(split) && solve(s,endIdx,wordDict)){
                return t[idx] = true;
            }
        }
        return t[idx] = false ;
    }
}
