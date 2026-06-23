// Date: 23-06-2026
// 3699. Number of ZigZag Arrays I
// https://leetcode.com/problems/number-of-zigzag-arrays-i/?envType=daily-question&envId=2026-06-23

public class NumberofZigZagArraysI {
    class Solution {
        private static final int MOD = 1000000007;

        public int zigZagArrays(int n, int l, int r) {
            int m = r - l + 1;

            int[] dp = new int[m];
            java.util.Arrays.fill(dp, 1);

            for (int len = 2; len <= n; len++) {

                if ((len & 1) == 0) {
                    long pref = 0;

                    for (int i = 0; i < m; i++) {
                        int old = dp[i];

                        dp[i] = (int) pref;

                        pref = (pref + old) % MOD;
                    }
                } else {
                    long suff = 0;

                    for (int i = m - 1; i >= 0; i--) {
                        int old = dp[i];

                        dp[i] = (int) suff;

                        suff = (suff + old) % MOD;
                    }
                }
            }

            long ans = 0;

            for (int x : dp) {
                ans = (ans + x) % MOD;
            }

            return (int) ((ans * 2) % MOD);
        }
    }
    public static void main(String[] args) {
        NumberofZigZagArraysI zigZagArrays = new NumberofZigZagArraysI();
        Solution solution = zigZagArrays.new Solution();

        int n = 3;
        int l = 1;
        int r = 3;
        int result = solution.zigZagArrays(n, l, r);
        System.out.println(result); // Output: 6
    }
}
