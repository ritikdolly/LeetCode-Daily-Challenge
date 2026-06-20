// Date: 20-06-2026
// 1840. Maximum Building Height
// https://leetcode.com/problems/maximum-building-height/description/?envType=daily-question&envId=2026-06-20
import java.util.Arrays;

public class MaximumBuildingHeight {
    class Solution {
        public int maxBuilding(int n, int[][] restrictions) {
            int m = restrictions.length;

            int[][] arr = new int[m + 2][2];

            for (int i = 0; i < m; i++) {
                arr[i] = restrictions[i];
            }

            arr[m] = new int[] { 1, 0 };

            arr[m + 1] = new int[] { n, n - 1 };

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int size = arr.length;

            for (int i = 1; i < size; i++) {
                int dist = arr[i][0] - arr[i - 1][0];

                arr[i][1] = Math.min(
                        arr[i][1],
                        arr[i - 1][1] + dist);
            }

            for (int i = size - 2; i >= 0; i--) {
                int dist = arr[i + 1][0] - arr[i][0];

                arr[i][1] = Math.min(
                        arr[i][1],
                        arr[i + 1][1] + dist);
            }

            long ans = 0;

            for (int i = 1; i < size; i++) {
                long x1 = arr[i - 1][0];
                long h1 = arr[i - 1][1];

                long x2 = arr[i][0];
                long h2 = arr[i][1];

                long dist = x2 - x1;

                long peak = Math.max(h1, h2) +
                        (dist - Math.abs(h1 - h2)) / 2;

                ans = Math.max(ans, peak);
            }

            return (int) ans;
        }
    }
    public static void main(String[] args) {
        MaximumBuildingHeight obj = new MaximumBuildingHeight();
        Solution solution = obj.new Solution();

        int n = 5;
        int[][] restrictions = { { 2, 1 }, { 4, 1 } };
        int result = solution.maxBuilding(n, restrictions);
        System.out.println(result); // Output: 2
    }
}
