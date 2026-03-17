// Date 17-03-2026
// 1727. Largest Submatrix With Rearrangements
// https://leetcode.com/problems/largest-submatrix-with-rearrangements/?envType=daily

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    // Method 1: O(m*n*log(n)) - using built in sort
    // class Solution {
    // public int largestSubmatrix(int[][] matrix) {
    // int m = matrix.length;
    // int n = matrix[0].length;

    // for (int i = 1; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // if (matrix[i][j] != 0) {
    // matrix[i][j] += matrix[i - 1][j];
    // }
    // }
    // }
    // int maxArea = 0;

    // for (int i = 0; i < m; i++) {
    // int[] row = matrix[i].clone();
    // Arrays.sort(row);

    // for (int j = n - 1; j >= 0; j--) {
    // int area = (n - j) * row[j];

    // maxArea = Math.max(maxArea, area);
    // }
    // }
    // return maxArea;
    // }
    // }

    // Method 2: O(m*n) - using counting sort
    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length, res = 0;
            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 1)
                        matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }

            for (int i = 0; i < m; ++i) {
                Arrays.sort(matrix[i]);
                for (int j = 1; j <= n; ++j) {
                    res = Math.max(res, j * matrix[i][n - j]);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
            LargestSubmatrixWithRearrangements obj = new LargestSubmatrixWithRearrangements();
            Solution sol = obj.new Solution();
    
            int[][] matrix = {
                {0,0,1},
                {1,1,1},
                {1,0,1}
            };
    
            System.out.println(sol.largestSubmatrix(matrix));
    }
}
