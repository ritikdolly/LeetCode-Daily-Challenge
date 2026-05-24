// Date: 24-05-2026
// 1340. Jump Game V
// https://leetcode.com/problems/jump-game-v/?envType=daily-question&envId=2026-05-24
public class JumpGameV {
    class Solution {
        int[] dp;

        public int maxJumps(int[] arr, int d) {
            int n = arr.length;
            dp = new int[n];

            int ans = 1;

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dfs(i, arr, d));
            }

            return ans;
        }

        private int dfs(int i, int[] arr, int d) {
            if (dp[i] != 0)
                return dp[i];

            int best = 1;

            for (int nxt = i + 1; nxt <= Math.min(arr.length - 1, i + d); nxt++) {
                if (arr[nxt] >= arr[i])
                    break;

                best = Math.max(best, 1 + dfs(nxt, arr, d));
            }

            for (int nxt = i - 1; nxt >= Math.max(0, i - d); nxt--) {
                if (arr[nxt] >= arr[i])
                    break;

                best = Math.max(best, 1 + dfs(nxt, arr, d));
            }

            return dp[i] = best;
        }
    }
    public static void main(String[] args) {
        Solution sol = new JumpGameV().new Solution();
        int[] arr = { 6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12 };
        int d = 2;
        System.out.println(sol.maxJumps(arr, d));
    }
}
