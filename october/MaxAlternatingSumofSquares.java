// Date: 13-10-2026
//problem title: 3727. Maximum Alternating Sum of Squares
//problem link: https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/?envType=daily-question&envId=2026-10-13

import java.util.Arrays;

class MaxAlternatingSumofSquares {


    // Approach: The idea is to maximize the alternating sum of squares by selecting the largest numbers for the positive terms and the smallest numbers for the negative terms. We can achieve this by sorting the array and then calculating the sum accordingly.
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                if (nums[i] < 0) {
                    nums[i] = Math.abs(nums[i]);
                }
            }
            Arrays.sort(nums);
            int mid = n / 2;

            long maxValue = 0;
            for (int i = mid; i < n; i++) {
                maxValue += nums[i] * nums[i];
            }

            for (int i = 0; i < mid; i++) {
                maxValue -= nums[i] * nums[i];
            }
            return maxValue;
        }
    }

    public static void main(String[] args) {
        MaxAlternatingSumofSquares maxAlternatingSumofSquares = new MaxAlternatingSumofSquares();
        Solution solution = maxAlternatingSumofSquares.new Solution();

        int[] nums = {1, 2, 3, 4, 5};
        long result = solution.maxAlternatingSum(nums);
        System.out.println(result); // Output: 45
    }
}
