// Date: 25-06-2026
// 3737. Count Subarrays With Majority Element I
// https://leetcode.com/problems/count-subarrays-with-majority-element-i/description/?envType=daily-question&envId=2026-06-25


public class CountSubarraysWithMajorityElementI {
    class Solution {
        public int countMajoritySubarrays(int[] nums, int target) {
            int n = nums.length;
            int ans = 0;

            for (int l = 0; l < n; l++) {
                int targetCount = 0;

                for (int r = l; r < n; r++) {
                    if (nums[r] == target) {
                        targetCount++;
                    }

                    int len = r - l + 1;

                    if (targetCount > len / 2) {
                        ans++;
                    }
                }
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        Solution solution = new CountSubarraysWithMajorityElementI().new Solution();
        int[] nums = {1, 2, 3, 2, 2};
        int target = 2;
        int result = solution.countMajoritySubarrays(nums, target);
        System.out.println("Number of majority subarrays: " + result);
    }
}
