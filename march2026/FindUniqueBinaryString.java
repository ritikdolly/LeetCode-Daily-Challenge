// Date : 08-03-2026
// 1980. Find Unique Binary String
// https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2026-03-08
public class FindUniqueBinaryString {
    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            int n = nums.length;
            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                // Flip the diagonal bit
                result[i] = nums[i].charAt(i) == '0' ? '1' : '0';
            }

            return new String(result);
        }
    }
    public static void main(String[] args) {
        FindUniqueBinaryString solution = new FindUniqueBinaryString();
        String[] nums = {"01", "10"};
        String result = solution.new Solution().findDifferentBinaryString(nums);
        System.out.println(result); // Output: "11"
    }
}
