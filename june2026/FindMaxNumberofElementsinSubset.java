// Date: 27-06-2026
// problem: 3020. Find the Maximum Number of Elements in Subset
// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/?envType=daily-question&envId=2026-06-27
import java.util.HashMap;
import java.util.Map;

public class FindMaxNumberofElementsinSubset {
    class Solution {

        public int maximumLength(int[] nums) {
            Map<Long, Integer> cnt = new HashMap<>();
            for (int num : nums) {
                cnt.merge((long) num, 1, Integer::sum);
            }

            int oneCnt = cnt.getOrDefault(1L, 0);
            // ans is at least the number of occurrences of 1, rounded down to an odd number
            int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;

            cnt.remove(1L);

            for (long num : cnt.keySet()) {
                int res = 0;
                long x = num;

                while (cnt.containsKey(x) && cnt.get(x) > 1) {
                    res += 2;
                    x *= x;
                }

                ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        FindMaxNumberofElementsinSubset solution = new FindMaxNumberofElementsinSubset();
        Solution sol = solution.new Solution();

        int[] nums1 = {1, 2, 4, 16, 256};
        System.out.println(sol.maximumLength(nums1)); // Output: 5

        int[] nums2 = {1, 3, 9, 81};
        System.out.println(sol.maximumLength(nums2)); // Output: 3

        int[] nums3 = {1, 2, 3, 4};
        System.out.println(sol.maximumLength(nums3)); // Output: 1
    }
}
