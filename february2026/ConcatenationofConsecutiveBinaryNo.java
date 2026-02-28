// Date 28-02-2026
// 1680. Concatenation of Consecutive Binary Numbers
// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/description/?envType=daily-question&envId=2026-02-28

public class ConcatenationofConsecutiveBinaryNo {
    class Solution {
        public int concatenatedBinary(int n) {
            long result = 0;
            int mod = 1000000007;
            int length = 0;

            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0) {
                    length++;
                }

                result = ((result << length) | i) % mod;
            }
            return (int) result;
        }
}
    public static void main(String[] args) {
        Solution solution = new ConcatenationofConsecutiveBinaryNo().new Solution();
        int n = 3;
        int result = solution.concatenatedBinary(n);
        System.out.println(result); // Output: 27   
    }
}
