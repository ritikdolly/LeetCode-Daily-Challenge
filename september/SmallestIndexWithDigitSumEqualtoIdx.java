// Date: 24-09-2026
// problem title: Smallest Index With Digit Sum Equal to Index
// problem link: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/?envType=daily-question&envId=2026-09-24

public class SmallestIndexWithDigitSumEqualtoIdx {

    // Approach 1: using brute force
    // class Solution {
    //     public int smallestIndex(int[] nums) {
    //         for (int i = 0; i < nums.length; i++) {

    //             int n = nums[i];
    //             int sum = 0;

    //             while (n > 0) {
    //                 int digit = n % 10;
    //                 sum = sum + digit;
    //                 n = n / 10;
    //             }

    //             if (sum == i) {
    //                 return i;
    //             }

    //         }
    //         return -1;
    //     }
    // }

    // Approach 2: using brute force with digit sum function
    class Solution {

        int digitSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

        public int smallestIndex(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (i == digitSum(nums[i])) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        SmallestIndexWithDigitSumEqualtoIdx obj = new SmallestIndexWithDigitSumEqualtoIdx();
        Solution solution = obj.new Solution();

        int[] nums1 = { 18, 29, 38, 49 };
        System.out.println(solution.smallestIndex(nums1)); // Output: 0

        int[] nums2 = { 10, 20, 30, 40 };
        System.out.println(solution.smallestIndex(nums2)); // Output: -1
    }
}
