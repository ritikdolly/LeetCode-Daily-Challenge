// Date: 20-03-2026
// 3567. Minimum Absolute Difference in Sliding Submatrix
// https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/?envType=daily-question&envId=2026-03-20

import java.util.*;
public class MinimumAbsoluteDifferenceinSlidingSubmatrix {

    // method 1: using TreeSet to find minimum difference in O(k^2 log k^2) time for each submatrix
    // class Solution {
    //     public int[][] minAbsDiff(int[][] grid, int k) {
    //         int m = grid.length, n = grid[0].length;
    //         int[][] ans = new int[m - k + 1][n - k + 1];

    //         for (int i = 0; i <= m - k; i++) {
    //             for (int j = 0; j <= n - k; j++) {

    //                 TreeSet<Integer> set = new TreeSet<>();

    //                 // Collect elements of k x k submatrix
    //                 for (int x = i; x < i + k; x++) {
    //                     for (int y = j; y < j + k; y++) {
    //                         set.add(grid[x][y]);
    //                     }
    //                 }

    //                 // If only one unique element → answer = 0
    //                 if (set.size() <= 1) {
    //                     ans[i][j] = 0;
    //                     continue;
    //                 }

    //                 // Compute minimum difference between adjacent sorted elements
    //                 int minDiff = Integer.MAX_VALUE;
    //                 Integer prev = null;

    //                 for (int val : set) {
    //                     if (prev != null) {
    //                         minDiff = Math.min(minDiff, val - prev);
    //                     }
    //                     prev = val;
    //                 }

    //                 ans[i][j] = minDiff;
    //             }
    //         }

    //         return ans;
    //     }
    // }

    // Method 2: using sorting to find minimum difference in O(k^2 log k^2) time for each submatrix
    class Solution {
        public int[][] minAbsDiff(int[][] grid, int k) {
            int[][] res = new int[grid.length - k + 1][grid[0].length - k + 1];
            for (int i = k - 1; i < grid.length; i++) {
                for (int j = k - 1; j < grid[0].length; j++) {
                    int[] temp = new int[k * k];
                    for (int ii = i - k + 1; ii <= i; ii++) {
                        for (int jj = j - k + 1; jj <= j; jj++) {
                            temp[(ii - (i - k + 1)) * k + (jj - (j - k + 1))] = grid[ii][jj];
                        }
                    }
                    Arrays.sort(temp);
                    res[i - (k - 1)][j - (k - 1)] = temp[temp.length - 1] - temp[0];
                    for (int kk = 1; kk < temp.length; kk++) {
                        if (temp[kk] == temp[kk - 1]) {
                            continue;
                        }
                        res[i - (k - 1)][j - (k - 1)] = Math.min(res[i - (k - 1)][j - (k - 1)],
                                temp[kk] - temp[kk - 1]);
                    }
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution sol = new MinimumAbsoluteDifferenceinSlidingSubmatrix().new Solution();
        int[][] grid = {
            {1, 3, 2},
            {4, 6, 5},
            {7, 9, 8}
        };
        int k = 2;
        int[][] result = sol.minAbsDiff(grid, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
