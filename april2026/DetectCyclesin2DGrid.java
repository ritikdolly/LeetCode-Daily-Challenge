// Date: 26-04-2026
// 1559. Detect Cycles in 2D Grid
// https://leetcode.com/problems/detect-cycles-in-2d-grid/description/?envType=daily-question&envId=2026-04-26


public class DetectCyclesin2DGrid {
    class Solution {
        char[][] grid;
        boolean[][] dfs_mat;
        int m, n;

        public boolean dfs(int i, int j, int pi, int pj) {
            int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            dfs_mat[i][j] = true;

            for (int x = 0; x < 4; x++) {
                int ni = i + directions[x][0], nj = j + directions[x][1];

                if ((ni >= 0) && (ni < m) && (nj >= 0) && (nj < n))
                    if (grid[ni][nj] == grid[i][j]) {
                        if ((ni == pi) && (nj == pj))
                            continue;
                        if (dfs_mat[ni][nj])
                            return true;
                        if (dfs(ni, nj, i, j))
                            return true;
                    }
            }

            return false;
        }

        public boolean containsCycle(char[][] grid) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            this.dfs_mat = new boolean[m][n];

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (!dfs_mat[i][j])
                        if (dfs(i, j, -1, -1))
                            return true;

            return false;
        }
    }

    public static void main(String[] args) {
        DetectCyclesin2DGrid.Solution solution = new DetectCyclesin2DGrid().new Solution();
        char[][] grid = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' } };
        System.out.println(solution.containsCycle(grid));
    }
}
