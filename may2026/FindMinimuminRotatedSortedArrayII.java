// Date: 16-05-2026
// 154. Find Minimum in Rotated Sorted Array II
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/?envType=daily-question&envId=2026-05-16

public class FindMinimuminRotatedSortedArrayII {
    // method 1: binary search with duplicates - O(n) in worst case
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < nums[right]) {
                    right = mid;

                } else if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right--;
                }
            }
            return nums[left];
        }
    }
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArrayII f = new FindMinimuminRotatedSortedArrayII();
        Solution s = f.new Solution();

        int[] nums = {2, 2, 2, 0, 1};

        System.out.println(s.findMin(nums));
    }
}