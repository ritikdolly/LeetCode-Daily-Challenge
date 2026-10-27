// Date: 27-06-2026
// problem title:
// problem link: https://leetcode.com/problems/create-grid-with-exactly-one-path/description/?envType=daily-question&envId=2026-10-27

import java.util.Arrays;

public class CreateGridWithExactlyOnePath {

    // Approach 1: Using String array
    class Solution {
        public String[] createGrid(int m, int n) {
            String[] ans = new String[m];

            Arrays.fill(ans, "#".repeat(n - 1) + ".");
            ans[0] = ".".repeat(n);
            return ans;
        }
    }

    // Approach 2: Using 2D char array
    // class Solution {
    //     public String[] createGrid(int m, int n) {
    //         char[][] g = new char[m][n];
    //         for (int i = 0; i < m; i++) {
    //             Arrays.fill(g[i], '#');
    //         }

    //         Arrays.fill(g[0], '.');

    //         for (int i = 0; i < m; i++) {
    //             g[i][n - 1] = '.';
    //         }

    //         String[] ans = new String[m];
    //         for (int i = 0; i < m; i++) {
    //             ans[i] = new String(g[i]);
    //         }
    //         return ans;
    //     }
    // }

    public static void main(String[] args) {
        CreateGridWithExactlyOnePath solution = new CreateGridWithExactlyOnePath();
        Solution sol = solution.new Solution();

        int m = 3;
        int n = 4;

        String[] result = sol.createGrid(m, n);

        for (String row : result) {
            System.out.println(row);
        }
    }
}
