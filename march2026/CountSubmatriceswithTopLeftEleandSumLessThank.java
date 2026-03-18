// Date: 18-03-2026
// 3070. Count Submatrices with Top-Left Element and Sum Less Than k
// http://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/?envType=daily-question&envId=2026-03-18


public class CountSubmatriceswithTopLeftEleandSumLessThank {

    // method 1: O(m*n) - using cumulative sum
    // class Solution {

    //     public int countSubmatrices(int[][] grid, int k) {
    //         int n = grid.length;
    //         int m = grid[0].length;
    //         int[] cols = new int[m];
    //         int res = 0;

    //         for (int i = 0; i < n; i++) {
    //             int rows = 0;
    //             for (int j = 0; j < m; j++) {
    //                 cols[j] += grid[i][j];
    //                 rows += cols[j];
    //                 if (rows <= k) {
    //                     res++;
    //                 }
    //             }
    //         }

    //         return res;
    //     }
    // }

    // Methoed 2: O(m*n) - using prefix sum
    class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;

            // Prefix sum calculation in-place
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (i > 0)
                        grid[i][j] += grid[i - 1][j];
                    if (j > 0)
                        grid[i][j] += grid[i][j - 1];
                    if (i > 0 && j > 0)
                        grid[i][j] -= grid[i - 1][j - 1];

                    // Check condition
                    if (grid[i][j] <= k) {
                        count++;
                    }
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        CountSubmatriceswithTopLeftEleandSumLessThank obj = new CountSubmatriceswithTopLeftEleandSumLessThank();
        Solution sol = obj.new Solution();

        int[][] grid = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        int k = 4;

        int result = sol.countSubmatrices(grid, k);
        System.out.println(result); // Output: 10
    }
}
