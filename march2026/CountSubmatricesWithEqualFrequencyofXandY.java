// Date : 19-03-2026
// 3212. Count Submatrices With Equal Frequency of X and Y
// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/?envType=daily-question&envId=2026-03-19

public class CountSubmatricesWithEqualFrequencyofXandY {
    class Solution {
        public int numberOfSubmatrices(char[][] grid) {
            int ans = 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] preSum = new int[m + 1][n + 1];

            boolean[] seen = new boolean[n + 1];

            for (int i = 1; i <= m; i++) {
                boolean seenRow = false;
                for (int j = 1; j <= n; j++) {
                    char ch = grid[i - 1][j - 1];

                    if (ch == 'X') {
                        seen[j] = true;
                    }

                    if (seen[j]) {
                        seenRow = true;
                    }

                    int val = (ch == 'X') ? 1 : (ch == 'Y') ? -1 : 0;

                    preSum[i][j] = val + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];

                    if (preSum[i][j] == 0 && (seen[j] || seenRow)) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution sol = new CountSubmatricesWithEqualFrequencyofXandY().new Solution();
        char[][] grid = {
            {'X', 'Y', 'X'},
            {'Y', 'X', 'Y'},
            {'X', 'Y', 'X'}
        };
        System.out.println(sol.numberOfSubmatrices(grid)); // Output the result
    }
}
