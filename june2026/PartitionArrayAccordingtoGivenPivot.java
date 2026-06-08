// Date:08-06-2026
// 2161. Partition Array According to Given Pivot
// https://leetcode.com/problems/partition-array-according-to-given-pivot/?envType=daily-question&envId=2026-06-08

public class PartitionArrayAccordingtoGivenPivot {
    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int n = nums.length;
            int[] ans = new int[n];

            int left = 0;
            int right = n - 1;

            int i = 0;
            int j = n - 1;

            while (i < n) {
                if (nums[i] < pivot) {
                    ans[left++] = nums[i];
                }

                if (nums[j] > pivot) {
                    ans[right--] = nums[j];
                }

                i++;
                j--;
            }

            // Remaining positions contain pivot
            while (left <= right) {
                ans[left++] = pivot;
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        Solution solution = new PartitionArrayAccordingtoGivenPivot().new Solution();
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        int[] result = solution.pivotArray(nums, pivot);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
