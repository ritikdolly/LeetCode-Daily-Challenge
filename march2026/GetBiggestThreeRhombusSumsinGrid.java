// Date : 16-03-2026
//1878. Get Biggest Three Rhombus Sums in a Grid
// https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/?envType=daily-question&envId=2026-03-16 

import java.util.*;

public class GetBiggestThreeRhombusSumsinGrid {

    class Solution {
        public int[] getBiggestThree(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {

                    set.add(grid[r][c]); // single cell rhombus

                    for (int size = 1; r + 2 * size < m && c - size >= 0 && c + size < n; size++) {

                        int sum = 0;

                        int x = r, y = c;

                        // top -> right
                        for (int i = 0; i < size; i++) {
                            sum += grid[x + i][y + i];
                        }

                        // right -> bottom
                        for (int i = 0; i < size; i++) {
                            sum += grid[x + size + i][y + size - i];
                        }

                        // bottom -> left
                        for (int i = 0; i < size; i++) {
                            sum += grid[x + 2 * size - i][y - i];
                        }

                        // left -> top
                        for (int i = 0; i < size; i++) {
                            sum += grid[x + size - i][y - size + i];
                        }

                        set.add(sum);
                    }
                }
            }

            int k = Math.min(3, set.size());
            int[] ans = new int[k];

            int i = 0;
            for (int val : set) {
                if (i == 3)
                    break;
                ans[i++] = val;
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        Solution solution = new GetBiggestThreeRhombusSumsinGrid().new Solution();
        int[][] grid = {{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}};
        System.out.println(Arrays.toString(solution.getBiggestThree(grid)));
    }
}
