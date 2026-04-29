// Dat: 28-04-2026
// 2033. Minimum Operations to Make a Uni-Value Grid
// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/?envType=daily-question&envId=2026-04-28

public class MinOperationstoMakeUniValueGrid {
    class Solution {
        public int minOperations(int[][] grid, int x) {
            int n = grid.length, m = grid[0].length;
            int N = n * m;
            int[] freq = new int[10001];
            int min = grid[0][0], max = min;

            for (int[] row : grid) {
                for (int val : row) {
                    if ((val - grid[0][0]) % x != 0)
                        return -1;
                    freq[val]++;
                    min = Math.min(min, val);
                    max = Math.max(max, val);
                }
            }

            int target = (N + 1) / 2;
            int acc = 0, median = min;

            for (int i = min; i <= max; i += x) {
                acc += freq[i];
                if (acc >= target) {
                    median = i;
                    break;
                }
            }

            int ops = 0;
            for (int i = min; i <= max; i += x)
                ops += Math.abs(i - median) / x * freq[i];

            return ops;
        }
    }
    public static void main(String[] args) {
        MinOperationstoMakeUniValueGrid.Solution solution = new MinOperationstoMakeUniValueGrid().new Solution();
        int[][] grid = { { 2, 4 }, { 6, 8 } };
        int x = 2;
        System.out.println(solution.minOperations(grid, x));
    }
}
