// Date: 06-09-2026
// Problem Title: 115. Distinct Subsequences
//problem link: https://leetcode.com/problems/distinct-subsequences/description/?envType=daily-question&envId=2026-09-06

public class DistinctSubsequences {
    class Solution {
        public int numDistinct(String s, String t) {
            int m = t.length();

            long[] dp = new long[m + 1];
            dp[0] = 1;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                for (int j = m; j >= 1; j--) {
                    if (c == t.charAt(j - 1)) {
                        dp[j] += dp[j - 1];
                    }
                }
            }

            return (int) dp[m];
        }
    }
    public static void main(String[] args) {
        DistinctSubsequences obj = new DistinctSubsequences();
        Solution solution = obj.new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        int result = solution.numDistinct(s, t);
        System.out.println("The number of distinct subsequences is: " + result);
    }
}
