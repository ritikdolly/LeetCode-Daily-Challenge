// Date: 15-05-2026
// 153. Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/2003663854/?envType=daily-question&envId=2026-05-15
public class FindMinimuminRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
        Solution s = f.new Solution();

        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(s.findMin(nums));
    }
}
