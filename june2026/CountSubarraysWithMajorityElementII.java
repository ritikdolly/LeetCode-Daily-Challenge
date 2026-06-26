// Date: 26-06-2026
// 3739. Count Subarrays With Majority Element II
// https://leetcode.com/problems/count-subarrays-with-majority-element-ii/description/?envType=daily-question&envId=2026-06-26

public class CountSubarraysWithMajorityElementII {

    // Approach 1: Brute Force
    // class Solution {
    // public long countMajoritySubarrays(int[] nums, int target) {
    // int n = nums.length;
    // long cnt = 0;

    // for (int i = 0; i < n; i++) {
    // int freq = 0;

    // for (int j = i; j < n; j++) {
    // if (nums[j] == target) {
    // freq++;
    // }

    // int len = j - i + 1;

    // if (freq > len / 2) {
    // cnt++;
    // }
    // }
    // }

    // return cnt;
    // }
    // }

    // Approach 2: Prefix Sum + HashMap
    class Solution {
        public long countMajoritySubarrays(int[] nums, int target) {
            int n = nums.length;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] == target)
                    nums[i] = 1;
                else
                    nums[i] = -1;
            }

            int[] pref = new int[n];
            pref[0] = nums[0];

            for (int i = 1; i < n; i++) {
                pref[i] = pref[i - 1] + nums[i];
            }

            int shift = n;
            int[] freq = new int[2 * n + 1];

            freq[shift] = 1;

            long valid = 0;
            int lastSum = 0;

            for (int i = 0; i < n; i++) {
                if (pref[i] > lastSum) {
                    valid += freq[lastSum + shift];
                } else {
                    valid -= freq[pref[i] + shift];
                }

                cnt += valid;
                freq[pref[i] + shift]++;
                lastSum = pref[i];
            }

            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new CountSubarraysWithMajorityElementII().new Solution();
        int[] nums = { 1, 2, 3, 2, 2 };
        int target = 2;
        long result = solution.countMajoritySubarrays(nums, target);
        System.out.println("Number of majority subarrays: " + result);
    }
}
