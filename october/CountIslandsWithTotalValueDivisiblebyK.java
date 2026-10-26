// Date:26-10-2026
// problem title: 3619. Count Islands With Total Value Divisible by K
// problem link: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/?envType=daily-question&envId=2026-10-26
public class CountIslandsWithTotalValueDivisiblebyK {
    class Solution {
        private int m, n;
        private int[][] grid;

        public int countIslands(int[][] grid, int k) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;

            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        long sum = dfs(i, j);

                        if (sum % k == 0) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }

        private long dfs(int r, int c) {
            if (r < 0 || r >= m || c < 0 || c >= n
                    || grid[r][c] == 0) {
                return 0;
            }

            long value = grid[r][c];

            // Mark this cell as visited.
            grid[r][c] = 0;

            value += dfs(r + 1, c);
            value += dfs(r - 1, c);
            value += dfs(r, c + 1);
            value += dfs(r, c - 1);

            return value;
        }
    }
    public static void main(String[] args) {
        CountIslandsWithTotalValueDivisiblebyK solution = new CountIslandsWithTotalValueDivisiblebyK();
        Solution sol = solution.new Solution();

        int[][] grid = {
                {1, 2, 0, 0},
                {3, 4, 0, 5},
                {0, 0, 6, 7},
                {8, 9, 0, 0}
        };
        int k = 5;

        int result = sol.countIslands(grid, k);
        System.out.println("Number of islands with total value divisible by " + k + ": " + result);
    }
}
