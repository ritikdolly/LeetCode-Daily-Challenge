// Date: 20-11-2026
// Problem Title:3041. Maximize Consecutive Elements in an Array After Modification
//Problem Link: https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/description/?envType=daily-question&envId=2026-11-20

import java.util.*;

public class MaxConsecutiveEleinArrAfterModification {

    // Approach 1: first we sort the array, then we can calculate the maximum consecutive elements in an array after modification.
    // class Solution {
    //     public int maxSelectedElements(int[] nums) {
    //         Arrays.sort(nums);

    //         Map<Integer, Integer> dp = new HashMap<>();
    //         int ans = 0;

    //         for (int x : nums) {
    //             int a = dp.getOrDefault(x, 0) + 1;
    //             int b = dp.getOrDefault(x + 1, 0) + 1;

    //             dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), a));
    //             dp.put(x + 2, Math.max(dp.getOrDefault(x + 2, 0), b));

    //             ans = Math.max(ans, Math.max(dp.get(x + 1), dp.get(x + 2)));
    //         }

    //         return ans;
    //     }
    // }

    // Approach 2: first we sort the array, then we can calculate the maximum consecutive elements in an array after modification.
    class Solution {
        public int maxSelectedElements(int[] nums) {
            int ans = 1;
            int prev = Integer.MIN_VALUE;
            // the length of the longest consecutive elements (seq0) ending in the
            // previous number
            int dp0 = 1;
            // the length of the longest consecutive elements (seq1) ending in the
            // previous number + 1
            int dp1 = 1;

            Arrays.sort(nums);

            for (final int num : nums) {
                if (num == prev) {
                    dp1 = dp0 + 1; // Append `num + 1` to seq0.
                } else if (num == prev + 1) {
                    ++dp0; // Append `num` to seq0.
                    ++dp1; // Add 1 to every number in seq0 and append `num + 1` to seq0.
                } else if (num == prev + 2) {
                    dp0 = dp1 + 1; // Append `num` to seq1.
                    dp1 = 1; // Start a new sequence [`num + 1`].
                } else {
                    dp0 = 1; // Start a new sequence [`num`].
                    dp1 = 1; // Start a new sequence [`num + 1`].
                }
                ans = Math.max(ans, Math.max(dp0, dp1));
                prev = num;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        MaxConsecutiveEleinArrAfterModification obj = new MaxConsecutiveEleinArrAfterModification();
        Solution solution = obj.new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.maxSelectedElements(nums));
    }
}
