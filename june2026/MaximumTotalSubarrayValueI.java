// Date: 09-06-2026
// 3689. Maximum Total Subarray Value I
// https://leetcode.com/problems/maximum-total-subarray-value-i/description/?envType=daily-question&envId=2026-06-09

public class MaximumTotalSubarrayValueI {
    class Solution {
        public long maxTotalValue(int[] nums, int k) {
            long min = Integer.MAX_VALUE;
            long max = Integer.MIN_VALUE;

            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            return k * (max - min);
        }
}
    public static void main(String[] args) {
        Solution solution = new MaximumTotalSubarrayValueI().new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        long result = solution.maxTotalValue(nums, k);
        System.out.println(result);
    }
}
