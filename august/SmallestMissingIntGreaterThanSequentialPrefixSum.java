// Date: 11-08-2026
// problem: 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/?envType=daily-question&envId=2026-08-11

import java.util.HashSet;

public class SmallestMissingIntGreaterThanSequentialPrefixSum {

    //Approach 1: Using HashSet
    // class Solution {
    //     public int missingInteger(int[] nums) {
    //         int n = nums.length;
    //         int c = nums[0];
    //         for (int i = 1; i < n; i++) {
    //             if (nums[i] == nums[i - 1] + 1) {
    //                 c += nums[i];
    //             } else {
    //                 break;
    //             }
    //         }
    //         HashSet<Integer> p = new HashSet<>();
    //         for (int num : nums) {
    //             p.add(num);
    //         }
    //         while (p.contains(c)) {
    //             c++;
    //         }
    //         return c;
    //     }
    // }

    // Approach 2: Brute Force
    class Solution {
        public int missingInteger(int[] nums) {
            int n = nums.length;

            int sequentialSum = nums[0];

            // Find sequential prefix sum
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1] + 1)
                    sequentialSum += nums[i];
                else
                    break;
            }

            // Brute force search
            while (true) {
                boolean found = false;

                for (int num : nums) {
                    if (num == sequentialSum) {
                        found = true;
                        break;
                    }
                }

                if (!found)
                    return sequentialSum;

                sequentialSum++;
            }
        }
    }

    public static void main(String[] args) {
        SmallestMissingIntGreaterThanSequentialPrefixSum solution = new SmallestMissingIntGreaterThanSequentialPrefixSum();
        Solution sol = solution.new Solution();

        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(sol.missingInteger(nums1)); // Output: 16

        int[] nums2 = {1, 2, 3, 5, 6};
        System.out.println(sol.missingInteger(nums2)); // Output: 7

        int[] nums3 = {1, 2, 4, 5};
        System.out.println(sol.missingInteger(nums3)); // Output: 3
    }
}