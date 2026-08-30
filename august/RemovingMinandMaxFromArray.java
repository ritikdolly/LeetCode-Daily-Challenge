// Date: 30-08-2026
// 2091. Removing Minimum and Maximum From Array
// https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/?envType=daily-question&envId=2026-08-30
public class RemovingMinandMaxFromArray {
    class Solution {
        public int minimumDeletions(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIdx = 0;
            int maxIdx = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (min > nums[i]) {
                    min = nums[i];
                    minIdx = i;
                }
                if (max < nums[i]) {
                    max = nums[i];
                    maxIdx = i;
                }
            }
            int rightSide = n - Math.min(maxIdx, minIdx);
            int leftSide = Math.max(maxIdx, minIdx) + 1;
            int bothSide = (Math.min(maxIdx, minIdx) + 1) + (n - Math.max(maxIdx, minIdx));

            return Math.min(rightSide, Math.min(bothSide, leftSide));
        }
    }

    public static void main(String[] args) {
        RemovingMinandMaxFromArray obj = new RemovingMinandMaxFromArray();
        Solution solution = obj.new Solution();
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        int result = solution.minimumDeletions(nums);
        System.out.println(result); // Output: 5
    }
}
