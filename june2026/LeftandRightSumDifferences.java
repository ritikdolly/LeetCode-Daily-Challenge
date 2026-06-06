// Date: 06-06-2026
// 2574. Left and Right Sum Differences
// https://leetcode.com/problems/left-and-right-sum-differences/description/?envType=daily-question&envId=2026-06-06
public class LeftandRightSumDifferences {

    // Approach 1: Using two separate arrays to store left and right sums
    class Solution {
        public int[] leftRightDifference(int[] nums) {
            int n = nums.length;
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];

            leftSum[0] = 0;
            rightSum[n - 1] = 0;

            for (int i = 1; i < n; i++) {
                leftSum[i] = nums[i - 1] + leftSum[i - 1];
                rightSum[n - i - 1] = nums[n - i] + rightSum[n - i];
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = Math.abs(rightSum[i] - leftSum[i]);
            }
            return ans;
        }
    }

    // Approach 2: Using a single pass to calculate left and right sums on the fly
    // class Solution {
    //     public int[] leftRightDifference(int[] nums) {
    //         int leftSum = 0, rightSum = 0, n = nums.length;
    //         for (int num : nums)
    //             rightSum += num;
    //         for (int i = 0; i < n; i++) {
    //             int val = nums[i];
    //             rightSum -= val;
    //             nums[i] = Math.abs(leftSum - rightSum);
    //             leftSum += val;
    //         }
    //         return nums;
    //     }
    // }

    public static void main(String[] args) {
        Solution sol = new LeftandRightSumDifferences().new Solution();
        int[] nums = { 10, 4, 8, 3 };
        int[] result = sol.leftRightDifference(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: 15 1 11 22
    }
}
