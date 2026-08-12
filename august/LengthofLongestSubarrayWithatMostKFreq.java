// Date: 12-08-2026
// 2958. Length of Longest Subarray With at Most K Frequency
// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/?envType=daily-question&envId=2026-08-12

import java.util.HashMap;
import java.util.Map;

public class LengthofLongestSubarrayWithatMostKFreq {
    // Approach: Sliding Window
    class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            int ans = 0, start = -1;
            Map<Integer, Integer> frequency = new HashMap();

            for (int end = 0; end < nums.length; end++) {
                frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);
                while (frequency.get(nums[end]) > k) {
                    start++;
                    frequency.put(nums[start], frequency.get(nums[start]) - 1);
                }
                ans = Math.max(ans, end - start);
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        LengthofLongestSubarrayWithatMostKFreq solution = new LengthofLongestSubarrayWithatMostKFreq();
        Solution sol = solution.new Solution();

        int[] nums1 = {1, 2, 2, 3, 3, 3};
        int k1 = 2;
        System.out.println(sol.maxSubarrayLength(nums1, k1)); // Output: 5

        int[] nums2 = {1, 1, 1, 2, 2, 3};
        int k2 = 1;
        System.out.println(sol.maxSubarrayLength(nums2, k2)); // Output: 3
    }
}
