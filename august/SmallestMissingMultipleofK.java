import java.util.Arrays;

public class SmallestMissingMultipleofK {
    class Solution {
        public int missingMultiple(int[] nums, int k) {
            Arrays.sort(nums);
            int n = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == (k * n)) {
                    n++;
                }
            }
            return k * n;
        }
    }

    public static void main(String[] args) {
        SmallestMissingMultipleofK solution = new SmallestMissingMultipleofK();
        Solution sol = solution.new Solution();
        int[] nums = {3, 6, 9, 12};
        int k = 3;
        int result = sol.missingMultiple(nums, k);
        System.out.println("The smallest missing multiple of " + k + " is: " + result);
    }
}
