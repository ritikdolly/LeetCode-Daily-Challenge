
// date: 09-05-2026
// 1914. Cyclically Rotating a Grid
// https://leetcode.com/problems/cyclically-rotating-a-grid/description/?envType=daily-question&envId=2026-05-09
import java.util.*;

public class CyclicallyRotatingGrid {

    class Solution {
        private int[][] ans;
        private int m;
        private int n;

        public int[][] rotateGrid(int[][] grid, int k) {
            m = grid.length;
            n = grid[0].length;
            ans = new int[m][n];

            int layers = Math.min(m, n) / 2;

            for (int i = 0; i < layers; i++) {
                helper(i, grid, k);
            }

            return ans;
        }

        private void helper(int layer, int[][] grid, int k) {
            List<Integer> list = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            for (int j = left; j <= right; j++)
                list.add(grid[top][j]);

            for (int i = top + 1; i <= bottom - 1; i++)
                list.add(grid[i][right]);

            for (int j = right; j >= left; j--)
                list.add(grid[bottom][j]);

            for (int i = bottom - 1; i >= top + 1; i--)
                list.add(grid[i][left]);

            int size = list.size();
            k = k % size;

            Collections.rotate(list, -k);

            int idx = 0;

            for (int j = left; j <= right; j++) {
                ans[top][j] = list.get(idx++);
            }
            for (int i = top + 1; i <= bottom - 1; i++) {
                ans[i][right] = list.get(idx++);
            }
            for (int j = right; j >= left; j--) {
                ans[bottom][j] = list.get(idx++);
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                ans[i][left] = list.get(idx++);
            }
        }
    }
    public static void main(String[] args) {
        CyclicallyRotatingGrid c = new CyclicallyRotatingGrid();
        Solution s = c.new Solution();

        int[][] grid = {{40,10},{30,20}};
        int k = 1;

        int[][] ans = s.rotateGrid(grid, k);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
