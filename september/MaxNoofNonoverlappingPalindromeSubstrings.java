// DAte: 15-09-2026
// problem title:2472. Maximum Number of Non-overlapping Palindrome Substrings
// problem link:https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/description/?envType=daily-question&envId=2026-09-15

public class MaxNoofNonoverlappingPalindromeSubstrings {
    // Approach: Dynamic Programming 
    class Solution {

        public int maxPalindromes(String s, int k) {
            int n = s.length();
            boolean[][] isPalindrome = new boolean[n][n];

            for (int len = 1; len <= n; ++len) {
                for (int left = 0; left + len <= n; ++left) {
                    int right = left + len - 1;
                    isPalindrome[left][right] = s.charAt(left) == s.charAt(right) &&
                            (len <= 2 || isPalindrome[left + 1][right - 1]);
                }
            }

            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                dp[i] = dp[i - 1];
                for (int j = 0; j + k <= i; ++j) {
                    if (isPalindrome[j][i - 1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new MaxNoofNonoverlappingPalindromeSubstrings().new Solution();
        String s = "abaccdbbd";
        int k = 3;
        System.out.println(solution.maxPalindromes(s, k)); // Output: 2
    }
}
