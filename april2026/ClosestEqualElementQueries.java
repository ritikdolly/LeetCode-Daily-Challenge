// Date: 16-04-2026
// 3488. Closest Equal Element Queries
// https://leetcode.com/problems/closest-equal-element-queries/description/?envType=daily-question&envId=2026-04-16

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClosestEqualElementQueries {
    class Solution {

        public List<Integer> solveQueries(int[] nums, int[] queries) {
            int n = nums.length;
            int[] left = new int[n];
            int[] right = new int[n];

            HashMap<Integer, Integer> pos = new HashMap<>();
            for (int i = -n; i < n; i++) {
                if (i >= 0) {
                    left[i] = pos.getOrDefault(nums[i], i - n);
                }
                pos.put(nums[((i % n) + n) % n], i);
            }

            pos.clear();
            for (int i = 2 * n - 1; i >= 0; i--) {
                if (i < n) {
                    right[i] = pos.getOrDefault(nums[i], i + n);
                }
                pos.put(nums[i % n], i);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                int x = queries[i];
                if (x - left[x] == n) {
                    result.add(-1);
                } else {
                    result.add(Math.min(x - left[x], right[x] - x));
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ClosestEqualElementQueries sol = new ClosestEqualElementQueries();
        Solution solution = sol.new Solution();

        int[] nums1 = {1, 2, 3, 4, 2};
        int[] queries1 = {0, 1, 2, 3, 4};
        System.out.println(solution.solveQueries(nums1, queries1)); // Output: [-1, 3, 1, -1, 1]

        int[] nums2 = {5, 5, 5};
        int[] queries2 = {0, 1, 2};
        System.out.println(solution.solveQueries(nums2, queries2)); // Output: [1, 1, 1]

        int[] nums3 = {1, 2, 3};
        int[] queries3 = {0, 1, 2};
        System.out.println(solution.solveQueries(nums3, queries3)); // Output: [-1, -1, -1]
    }
}
