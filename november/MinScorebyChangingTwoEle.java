// Date: 19-11-2026
// Problem Titles: 2567. Minimum Score by Changing Two Elements
// problem link: https://leetcode.com/problems/minimum-score-by-changing-two-elements/description/?envType=daily-question&envId=2026-11-19

import java.util.Arrays;

public class MinScorebyChangingTwoEle {

    // Approach 1: first we sort the array, then we can calculate the minimum score by changing two elements.
    // class Solution {
    //     public int minimizeSum(int[] nums) {
    //         Arrays.sort(nums);
    //         int n = nums.length;

    //         return Math.min(nums[n - 2] - nums[1], Math.min(nums[n - 3] - nums[0], nums[n - 1] - nums[2]));
    //     }
    // }

    // Approach 2: first we find the three smallest and three largest elements in the array, then we can calculate the minimum score by changing two elements.
    class Solution {

        public int minimizeSum(int[] nums) {
            int mn1 = Integer.MAX_VALUE,
                    mn2 = Integer.MAX_VALUE,
                    mn3 = Integer.MAX_VALUE;
            int mx1 = Integer.MIN_VALUE,
                    mx2 = Integer.MIN_VALUE,
                    mx3 = Integer.MIN_VALUE;

            for (int x : nums) {
                if (x < mn1) {
                    mn3 = mn2;
                    mn2 = mn1;
                    mn1 = x;
                } else if (x < mn2) {
                    mn3 = mn2;
                    mn2 = x;
                } else if (x < mn3) {
                    mn3 = x;
                }

                if (x > mx1) {
                    mx3 = mx2;
                    mx2 = mx1;
                    mx1 = x;
                } else if (x > mx2) {
                    mx3 = mx2;
                    mx2 = x;
                } else if (x > mx3) {
                    mx3 = x;
                }
            }

            return Math.min(mx1 - mn3, Math.min(mx2 - mn2, mx3 - mn1));
        }
    }

    public static void main(String[] args) {
        MinScorebyChangingTwoEle obj = new MinScorebyChangingTwoEle();
        Solution solution = obj.new Solution();
        int[] nums = {1, 5, 0, 10, 14};
        System.out.println(solution.minimizeSum(nums));
    }
}
