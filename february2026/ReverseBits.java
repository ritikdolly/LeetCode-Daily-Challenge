// date : 16-02-2026
// 190. Reverse Bits
// https://leetcode.com/problems/reverse-bits/?envType=daily-question&envId=2026-02-16

public class ReverseBits {
    class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ret = 0, power = 31;
            while (n != 0) {
                ret += (n & 1) << power;
                n = n >>> 1;
                power -= 1;
            }
            return ret;
        }
    }

    private static void main(String[] args) {
        Solution sol = new ReverseBits().new Solution();
        int n = 43261596;
        System.out.println(sol.reverseBits(n));
    }
}