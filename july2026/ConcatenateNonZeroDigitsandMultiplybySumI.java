// Date: 07-07-2026
// 3754. Concatenate Non-Zero Digits and Multiply by Sum I
// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/?envType=daily-question&envId=2026-07-07

public class ConcatenateNonZeroDigitsandMultiplybySumI {
    class Solution {
        public long sumAndMultiply(int n) {
            long x = 0, s = 0;
            for (char c : String.valueOf(n).toCharArray())
                if (c != '0') {
                    x = x * 10 + c - '0';
                    s += c - '0';
                }
            return x * s;
        }
    }
    public static void main(String[] args) {
        ConcatenateNonZeroDigitsandMultiplybySumI outer = new ConcatenateNonZeroDigitsandMultiplybySumI();
        Solution solution = outer.new Solution();

        int n1 = 123405;
        System.out.println(solution.sumAndMultiply(n1)); // Output: 12345 * (1 + 2 + 3 + 4 + 5) = 12345 * 15 = 185175

        int n2 = 1002003;
        System.out.println(solution.sumAndMultiply(n2)); // Output: 123 * (1 + 2 + 3) = 123 * 6 = 738

        int n3 = 0;
        System.out.println(solution.sumAndMultiply(n3)); // Output: 0
    }
}
