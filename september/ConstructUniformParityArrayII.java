// Date: 03-09-2026
// 3876. Construct Uniform Parity Array II
// https://leetcode.com/problems/construct-uniform-parity-array-ii/description/?envType=daily-question&envId=2026-09-03

public class ConstructUniformParityArrayII {
    class Solution {

        public boolean uniformArray(int[] nums1) {
            int mn = nums1[0];
            boolean hasOdd = false;
            for (int v : nums1) {
                if (v < mn) {
                    mn = v;
                }
                if ((v & 1) == 1) {
                    hasOdd = true;
                }
            }
            if ((mn & 1) == 1) {
                return true;
            }
            return !hasOdd;
        }
    }
    public static void main(String[] args) {
        ConstructUniformParityArrayII obj = new ConstructUniformParityArrayII();
        Solution solution = obj.new Solution();
        int[] nums1 = {2, 4, 6, 8};
        boolean result = solution.uniformArray(nums1);
        System.out.println(result); // Output: true
    }

}