// Date: 26-06-2026
// 3739. Count Subarrays With Majority Element II
// https://leetcode.com/problems/count-subarrays-with-majority-element-ii/description/?envType=daily-question&envId=2026-06-26

public class CountSubarraysWithMajorityElementII {
    class Solution {
        public long countMajoritySubarrays(int[] nums, int target) {
            int n = nums.length;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                int freq = 0;

                for (int j = i; j < n; j++) {
                    if (nums[j] == target) {
                        freq++;
                    }

                    int len = j - i + 1;

                    if (freq > len / 2) {
                        cnt++;
                    }
                }
            }

            return cnt;
        }
    }
    public static void main(String[] args) {
        Solution solution = new CountSubarraysWithMajorityElementII().new Solution();
        int[] nums = {1, 2, 3, 2, 2};
        int target = 2;
        long result = solution.countMajoritySubarrays(nums, target);
        System.out.println("Number of majority subarrays: " + result);
    }
}
