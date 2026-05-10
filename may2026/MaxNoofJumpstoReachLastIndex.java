// Date: 10-05-2026
// 2770. Maximum Number of Jumps to Reach the Last Index
// https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/description/?envType=daily-question&envId=2026-05-10

import java.util.Arrays;

public class MaxNoofJumpstoReachLastIndex {

    class Solution {
        public int maximumJumps(int[] nums, int target) {
            int n = nums.length;

            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            int val = find(0, target, dp, nums);
            return val == Integer.MIN_VALUE ? -1 : val;
        }

        public int find(int ind, int target, int[] dp, int[] nums) {
            if (ind == nums.length - 1)
                return 0;

            if (ind >= nums.length)
                return Integer.MIN_VALUE;

            if (dp[ind] != -1)
                return dp[ind];
            int maxi = Integer.MIN_VALUE;
            for (int i = ind + 1; i < nums.length; i++) {
                int val = Integer.MIN_VALUE;
                if (Math.abs(nums[ind] - nums[i]) <= target) {
                    val = find(i, target, dp, nums);
                    if (val != Integer.MIN_VALUE) {
                        val++;
                    }
                }
                maxi = Math.max(maxi, val);
            }
            return dp[ind] = maxi;
        }
    }

    public static void main(String[] args) {
        MaxNoofJumpstoReachLastIndex m = new MaxNoofJumpstoReachLastIndex();
        Solution s = m.new Solution();

        int[] nums = {1, 3, 6, 4, 1, 2};
        int target = 2;

        System.out.println(s.maximumJumps(nums, target));
    }
}