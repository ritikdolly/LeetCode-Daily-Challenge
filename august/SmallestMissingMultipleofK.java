import java.util.Arrays;

public class SmallestMissingMultipleofK {

    // Approach: 1 Sort + Linear Scan
    // class Solution {
    //     public int missingMultiple(int[] nums, int k) {
    //         Arrays.sort(nums);
    //         int n = 1;
    //         for (int i = 0; i < nums.length; i++) {
    //             if (nums[i] == (k * n)) {
    //                 n++;
    //             }
    //         }
    //         return k * n;
    //     }
    // }


    // Approach: 2 Brute Force
    class Solution {
        public int missingMultiple(int[] nums, int k) {
            for (int multiple = k;; multiple += k) {
                boolean found = false;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == multiple) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return multiple;
                }
            }

        }
    }

    public static void main(String[] args) {
        SmallestMissingMultipleofK solution = new SmallestMissingMultipleofK();
        Solution sol = solution.new Solution();
        int[] nums = { 3, 6, 9, 12 };
        int k = 3;
        int result = sol.missingMultiple(nums, k);
        System.out.println("The smallest missing multiple of " + k + " is: " + result);
    }
}
