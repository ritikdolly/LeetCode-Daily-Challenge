// Date: 06-07-2026
// 1288. Remove Covered Intervals
// https://leetcode.com/problems/remove-covered-intervals/description/?envType=daily-question&envId=2026-07-06

import java.util.Arrays;

public class RemoveCoveredIntervals {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

            int count = 0;
            int maxEnd = 0;

            for (int[] interval : intervals) {
                if (interval[1] > maxEnd) {
                    count++;
                    maxEnd = interval[1];
                }
            }

            return count;
        }
    }
    public static void main(String[] args) {
        RemoveCoveredIntervals outer = new RemoveCoveredIntervals();
        Solution solution = outer.new Solution();

        int[][] intervals1 = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(solution.removeCoveredIntervals(intervals1)); // Output: 2

        int[][] intervals2 = {{1, 2}, {1, 4}, {3, 4}};
        System.out.println(solution.removeCoveredIntervals(intervals2)); // Output: 1

        int[][] intervals3 = {{1, 4}, {2, 3}};
        System.out.println(solution.removeCoveredIntervals(intervals3)); // Output: 1
    }
}
