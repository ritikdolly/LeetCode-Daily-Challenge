// Date: 23-05-2026
// 1752. Check if Array Is Sorted and Rotated
// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/?envType=daily-question&envId=2026-05-23
public class CheckifArrayIsSortedandRotated {

    // ?Approach 1: using pivot+ checking left and right side of arrays
    // class Solution {
    // public boolean check(int[] nums) {
    // int pivot = -1;
    // int n = nums.length;

    // // find pivot from where it is rotated
    // for (int i = 0; i < n - 1; i++) {
    // if (nums[i] > nums[i + 1]) {
    // pivot = i;
    // break;
    // }
    // }

    // // if pivot== -1 then array is in sorted from
    // if (pivot == -1) {
    // return true;
    // }

    // // checking left side of arrays
    // for (int i = 0; i < pivot; i++) {
    // if (nums[i] > nums[i + 1]) {
    // return false;
    // }
    // }
    // // checking right side of arrays
    // for (int i = pivot + 1; i < n - 1; i++) {
    // if (nums[i] > nums[i + 1]) {
    // return false;
    // }
    // }

    // return nums[0] >= nums[n - 1];
    // }
    // }

    // ? Approach 2: using count of pairs where nums[i]>nums[i+1]
    class Solution {
        public boolean check(int[] nums) {
            int count = 0;
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                if (nums[i] > nums[(i + 1) % n]) {
                    count++;
                }
            }
            return count <= 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new CheckifArrayIsSortedandRotated().new Solution();
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(sol.check(nums));
    }
}
