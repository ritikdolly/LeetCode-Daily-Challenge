// Date: 21-03-2026
//3643. Flip Square Submatrix Vertically
// https://leetcode.com/problems/flip-square-submatrix-vertically/description/?envType=daily-question&envId=2026-03-21

public class FlipSquareSubmatrixVertically {
    class Solution {
        public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
            int m = grid.length;
            int n = grid[0].length;

            int top = x;
            int bottom = x + k - 1;

            while (top < bottom) {

                for (int j = y; j < y + k; j++) {
                    int temp = grid[top][j];
                    grid[top][j] = grid[bottom][j];
                    grid[bottom][j] = temp;
                }
                top++;
                bottom--;
            }
            return grid;
        }
    }
    public static void main(String[] args) {
        Solution solution = new FlipSquareSubmatrixVertically().new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int x = 0;
        int y = 0;
        int k = 2;
        int[][] result = solution.reverseSubmatrix(grid, x, y, k);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
