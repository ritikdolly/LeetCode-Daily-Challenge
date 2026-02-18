// Date: 18-02-2026
// 693. Binary Number with Alternating Bits

// https://leetcode.com/problems/binary-number-with-alternating-bits/description/?envType=daily-question&envId=2026-02-18


public class BinaryNumberwithAlternatingBits {
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int x = n ^ (n >> 1);
            return (x & (x + 1)) == 0;
        }
    }
    public static void main(String[] args) {
        Solution sol = new BinaryNumberwithAlternatingBits().new Solution();
        int n = 5;
        System.out.println(sol.hasAlternatingBits(n));
    }

}
