// date:14-05-2026
// 2784. Check if Array is Good
// https://leetcode.com/problems/check-if-array-is-good/description/?envType=daily-question&envId=2026-05-14


import java.util.HashSet;
import java.util.Set;

public class CheckifArrayisGood {
    class Solution {
        public boolean isGood(int[] nums) {
            int n = nums.length - 1;
            Set<Integer> seen = new HashSet<>();
            boolean dup = false;

            for (int num : nums) {
                if (num > n)
                    return false;

                if (seen.contains(num)) {
                    if (num < n || dup)
                        return false;
                    dup = true;
                    continue;
                }

                seen.add(num);
            }

            return true;
        }
    }
    public static void main(String[] args) {
        CheckifArrayisGood c = new CheckifArrayisGood();
        Solution s = c.new Solution();

        int[] nums = {1, 3, 3, 2};

        System.out.println(s.isGood(nums));
    }
}
