// Date: 02-03-2026
// 1536. Minimum Swaps to Arrange a Binary Grid
// https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/description/?envType=daily-question&envId=2026-03-02

public class MinimumSwapstoArrangeBinaryGrid {
    class Solution {
        public int minSwaps(int[][] grid) {
            int n = grid.length;

            int[] zeroes = new int[n];
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (grid[i][j] == 0) {
                        count++;
                    } else {
                        break;
                    }
                }
                zeroes[i] = count;
            }

            int swap = 0;
            for (int i = 0; i < n; i++) {
                int need = n - i - 1;
                int j = i;
                while (j < n && zeroes[j] < need) {
                    j++;
                }

                if (j == n) {
                    return -1;
                }

                while (i < j) {
                    int temp = zeroes[j];
                    zeroes[j] = zeroes[j - 1];
                    zeroes[j - 1] = temp;
                    swap++;
                    j--;
                }
            }
            return swap;
        }
    }

    public static void main(String[] args) {
        Solution solution = new MinimumSwapstoArrangeBinaryGrid().new Solution();
        int[][] grid = { { 0, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };
        int result = solution.minSwaps(grid);
        System.out.println(result); // Output: 3
    }
}
