// date : 24-03-2026
// 2906. Construct Product Matrix
// https://leetcode.com/problems/construct-product-matrix/description/?envType=daily-question&envId=2026-03-24

public class ConstructProductMatrix {
    class Solution {
        public int[][] constructProductMatrix(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int size = m * n;
            int mod = 12345;

            int[] arr = new int[size];

            // Convert 2D → 1D
            int idx = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[idx++] = grid[i][j] % mod;
                }
            }

            int[] prefix = new int[size];
            int[] suffix = new int[size];

            // Prefix
            prefix[0] = 1;
            for (int i = 1; i < size; i++) {
                prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
            }

            // Suffix
            suffix[size - 1] = 1;
            for (int i = size - 2; i >= 0; i--) {
                suffix[i] = (suffix[i + 1] * arr[i + 1]) % mod;
            }

            // Build result
            int[][] result = new int[m][n];
            idx = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = (prefix[idx] * suffix[idx]) % mod;
                    idx++;
                }
            }

            return result;
        }
    }
    public static void main(String[] args) {
        Solution solution = new ConstructProductMatrix().new Solution();
        int[][] grid = {{1, 2}, {3, 4}};
        int[][] result = solution.constructProductMatrix(grid);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
