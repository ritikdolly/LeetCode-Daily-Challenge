// Date : 2026-02-14
//! Title : 799 Champagne Tower
// ? https://leetcode.com/problems/champagne-tower/description/?envType=daily-question&envId=2026-02-14

public class ChampagneTower {

    // method 1 - Approach : Simulation
    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[][] glass = new double[101][101];
            glass[0][0] = poured;

            for (int i = 0; i < query_row; i++) {
                for (int j = 0; j <= i; j++) {
                    double extra = (glass[i][j] - 1) / 2.0;
                    if (extra > 0) {
                        glass[i + 1][j] += extra;
                        glass[i + 1][j + 1] += extra;
                    }
                    if (i == query_row && j == query_glass) {
                        Math.min(1, glass[query_row][query_glass]);
                    }
                }
            }
            return Math.min(1, glass[query_row][query_glass]);
        }
    }

    // method 2 - Approach : Dynamic Programming
    // class Solution {
    // public double champagneTower(int poured, int row, int col) {
    // double[] dp = new double[col + 2];
    // dp[0] = poured;
    // for (int i = 0; i < row; i++) {
    // for (int j = Math.min(i, col); j >= 0; j--) {
    // if (dp[j] > 1) {
    // double val = (dp[j] - 1) / 2.0;
    // dp[j] = val;
    // dp[j + 1] += val;
    // } else
    // dp[j] = 0;
    // }
    // }
    // return Math.min(1, dp[col]);
    // }
    // }

    public static void main(String[] args) {
        Solution sol = new ChampagneTower().new Solution();
        int poured = 25, query_row = 6, query_glass = 1;
        System.out.println(sol.champagneTower(poured, query_row, query_glass));
    }
}