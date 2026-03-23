// Date: 23-03-2026
// 1594. Maximum Non Negative Product in a Matrix      
// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/description/?envType=daily-question&envId=2026-03-23

public class MaximumNonNegativeProductinMatrix {
    class Solution {
        public int maxProductPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            long[][] maxDP = new long[m][n];
            long[][] minDP = new long[m][n];

            maxDP[0][0] = grid[0][0];
            minDP[0][0] = grid[0][0];

            // col
            for (int i = 1; i < n; i++) {
                maxDP[0][i] = maxDP[0][i - 1] * grid[0][i];
                minDP[0][i] = minDP[0][i - 1] * grid[0][i];
            }
            // row
            for (int i = 1; i < m; i++) {
                maxDP[i][0] = maxDP[i - 1][0] * grid[i][0];
                minDP[i][0] = minDP[i - 1][0] * grid[i][0];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    int val = grid[i][j];

                    long topMax = maxDP[i - 1][j] * val;
                    long topMin = minDP[i - 1][j] * val;
                    long leftMax = maxDP[i][j - 1] * val;
                    long leftMin = minDP[i][j - 1] * val;

                    maxDP[i][j] = Math.max(Math.max(topMax, topMin), Math.max(leftMax, leftMin));
                    minDP[i][j] = Math.min(Math.min(topMax, topMin), Math.min(leftMax, leftMin));

                }
            }
            return (maxDP[m - 1][n - 1] < 0 ? -1 : (int) (maxDP[m - 1][n - 1] % 1000000007));
        }
}
    public static void main(String[] args) {
        Solution solution = new MaximumNonNegativeProductinMatrix().new Solution();
        int[][] grid = {{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};
        System.out.println(solution.maxProductPath(grid)); // Output: 8
    }
}
