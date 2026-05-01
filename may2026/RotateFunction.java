// Date: 01-05-2026
// 396. Rotate Function
// https://leetcode.com/problems/rotate-function/description/?envType=daily-question&envId=2026-05-01

public class RotateFunction {
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return 0;
            }
            long sum = 0;
            long f0 = 0;
            // Calculate sum and F(0)
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                f0 += (long) i * nums[i];
            }
            long max = f0;
            long current = f0;

            // Use relation:
            // F(k) = F(k-1) + sum - n * nums[n-k]
            for (int k = 1; k < n; k++) {
                current = current + sum - (long) n * nums[n - k];
                max = Math.max(max, current);
            }
            return (int) max;
        }
    }
    public static void main(String[] args) {
        RotateFunction.Solution solution = new RotateFunction().new Solution();
        int[] nums = {4, 3, 2, 6};
        int result = solution.maxRotateFunction(nums);
        System.out.println(result); // Output: 26
    }
}
