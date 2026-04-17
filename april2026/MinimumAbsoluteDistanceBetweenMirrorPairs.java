// Date:18-04-2026
// 3761. Minimum Absolute Distance Between Mirror Pairs
// https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/?envType=daily-question&envId=2026-04-17

import java.util.HashMap;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    class Solution {
        public int minMirrorPairDistance(int[] nums) {
            int res = 100000, i = 0;
            HashMap<Integer, Integer> seen = new HashMap<>();

            for (int n : nums) {
                int r;
                if (seen.containsKey(n))
                    res = Math.min(res, i - seen.get(n));

                for (r = 0; n > 0; n /= 10)
                    r = r * 10 + (n % 10);

                seen.put(r, i++);
            }

            return res == 100000 ? -1 : res;
        }
    }

    public static void main(String[] args) {
        MinimumAbsoluteDistanceBetweenMirrorPairs sol = new MinimumAbsoluteDistanceBetweenMirrorPairs();
        Solution solution = sol.new Solution();

        int[] nums1 = {12, 21, 13, 31, 14};
        System.out.println(solution.minMirrorPairDistance(nums1)); // Output: 1

        int[] nums2 = {123, 321, 456, 654, 789};
        System.out.println(solution.minMirrorPairDistance(nums2)); // Output: 1

        int[] nums3 = {10, 20, 30, 40, 50};
        System.out.println(solution.minMirrorPairDistance(nums3)); // Output: -1
    }

}