// Date: 05-03-2026
// 1758. Minimum Changes To Make Alternating Binary String
// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/?envType=daily-question&envId=2026-05-03

public class MinChangesToMakeAlternatingBinaryStr {
    class Solution {
        public int minOperations(String s) {
            int prev = 0;
            int count = 0;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                int bit = s.charAt(i) - '0';
                if (bit == prev) {
                    bit = 1 - prev;
                    count++;
                }
                prev = bit;
            }
            return Math.min(n - count, count);
        }
    }
    public static void main(String[] args) {
        
    }
}
