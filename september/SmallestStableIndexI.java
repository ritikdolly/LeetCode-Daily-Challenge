;// Date: 04-09-2026
 // problem Title: 3903. Smallest Stable Index I
 // problem link: https://leetcode.com/problems/smallest-stable-index-i/description/?envType=daily-question&envId=2026-09-04

public class SmallestStableIndexI {

    // Approach 1: Using two arrays to store the maximum and minimum values from the left and right respectively.
    // class Solution {
    //     public int firstStableIndex(int[] nums, int k) {
    //         int n = nums.length;
    //         int[] max = new int[n];
    //         int[] min = new int[n];
    //         max[0] = nums[0];
    //         min[n - 1] = nums[n - 1];

    //         for (int i = 1; i < nums.length; i++) {
    //             max[i] = Math.max(max[i - 1], nums[i]);
    //             min[n - i - 1] = Math.min(min[n - i], nums[n - i - 1]);
    //         }

    //         for (int i = 0; i < n; i++) {
    //             if ((max[i] - min[i]) <= k)
    //                 return i;
    //         }
    //         return -1;
    //     }
    // }

    // Approach 2: Using two pointers to find the maximum and minimum values from the left and right respectively.
    class Solution {
        public int firstStableIndex(int[] nums, int k) {
            int n = nums.length;
            int[] right = new int[n];
            right[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                right[i] = Math.min(right[i + 1], nums[i]);
            }
            int left = 0;
            for (int i = 0; i < n; i++) {
                left = Math.max(left, nums[i]);
                if (left - right[i] <= k) {
                    return i;
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        SmallestStableIndexI obj = new SmallestStableIndexI();
        Solution solution = obj.new Solution();
        int[] nums = { 1, 3, 6, 4, 1 };
        int k = 2;
        int result = solution.firstStableIndex(nums, k);
        System.out.println("The smallest stable index is: " + result);
    }

}
