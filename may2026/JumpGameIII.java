// Date : 17-05-2026
// 1306. Jump Game III
// https://leetcode.com/problems/jump-game-iii/description/?envType=daily-question&envId=2026-05-17

public class JumpGameIII {
    

    class Solution {
        public boolean canReach(int[] arr, int start) {
            if (start < 0 || start >= arr.length || arr[start] < 0)
                return false;
            if (arr[start] == 0)
                return true;
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);

        }
    }

    public static void main(String[] args) {
        JumpGameIII j = new JumpGameIII();
        Solution s = j.new Solution();

        int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
        int start = 5;

        System.out.println(s.canReach(arr, start));
    }
}