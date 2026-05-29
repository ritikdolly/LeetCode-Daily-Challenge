// Date: 29-05-2026
// 3300. Minimum Element After Replacement With Digit Sum
// https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/?envType=daily-question&envId=2026-05-29
public class MinEleAfterReplacementWithDigitSum {
    class Solution {
        int digitSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

        public int minElement(int[] nums) {
            int smallest = Integer.MAX_VALUE;
            for (int num : nums) {
                int n = digitSum(num);
                smallest = Math.min(smallest, n);
            }
            return smallest;
        }
    }
    public static void main(String[] args) {
        Solution sol = new MinEleAfterReplacementWithDigitSum().new Solution();
        int[] nums = {10, 12, 31, 41, 15, 66, 7, 8, 9};
        System.out.println(sol.minElement(nums)); // Output: 1
    }
}
