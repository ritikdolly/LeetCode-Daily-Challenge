// Date: 07-09-2026
//problem title: 940. Distinct Subsequences II
//problem link: https://leetcode.com/problems/distinct-subsequences-ii/description/?envType=daily-question&envId=2026-09-07

import java.util.HashSet;

public class DistinctSubsequencesII {

    // Approach 1: Backtracking (TLE)
    // class Solution {
    //     public int distinctSubseqII(String s) {
    //         HashSet<String> set = new HashSet<>();
    //         generate(s, 0, "", set);
    //         return set.size();
    //     }

    //     private void generate(String s, int index, String current,
    //             HashSet<String> set) {

    //         if (index == s.length()) {
    //             if (!current.isEmpty()) {
    //                 set.add(current);
    //             }
    //             return;
    //         }

    //         // Don't take current character
    //         generate(s, index + 1, current, set);

    //         // Take current character
    //         generate(s, index + 1, current + s.charAt(index), set);
    //     }
    // }

    // Approach 2: Dynamic Programming
    class Solution {
        public int distinctSubseqII(String s) {
            final int MOD = 1_000_000_007;
            long total = 0;
            long[] end = new long[26];

            for (char c : s.toCharArray()) {
                int i = c - 'a';

                long newSubseq = (total + 1 - end[i] + MOD) % MOD;
                total = (total + newSubseq) % MOD;
                end[i] = (end[i] + newSubseq) % MOD;
            }

            return (int) total;
        }
    }

    public static void main(String[] args) {
        DistinctSubsequencesII obj = new DistinctSubsequencesII();
        Solution solution = obj.new Solution();
        String s = "abc";
        int result = solution.distinctSubseqII(s);
        System.out.println("The number of distinct subsequences is: " + result);
    }
}
