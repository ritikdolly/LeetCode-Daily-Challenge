// Date: 07-05-2026
// 3660. Jump Game IX
// https://leetcode.com/problems/jump-game-ix/description/?envType=daily-question&envId=2026-05-07

public class JumpGameIX {

    class Solution {
        public int[] maxValue(int[] nums) {
            int n = nums.length, min = Integer.MAX_VALUE;
            int[] max = new int[n], ans = new int[n];
            max[0] = nums[0];
            for (int i = 1; i < n; i++){
                max[i] = Math.max(max[i - 1], nums[i]);
            }

            for (int i = n - 2; i >= 0; i--) {
                min = Math.min(min, nums[i + 1]);
                if (min < max[i])
                    max[i] = max[i + 1];
            }
            return max;
        }
    }
    public static void main(String[] args) {
        JumpGameIX j = new JumpGameIX();
        Solution s = j.new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int[] ans = s.maxValue(nums);
        for (int i : ans){
            System.out.print(i + " ");
        }
    }
}