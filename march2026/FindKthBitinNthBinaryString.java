// Date: 03-03-2026
// 1545. Find Kth Bit in Nth Binary String
// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/?envType=daily-question&envId=2026-03-03

public class FindKthBitinNthBinaryString {
    class Solution {
        public char findKthBit(int n, int k) {
            // Base case
            if (n == 1)
                return '0';

            int length = (1 << n) - 1; // 2^n - 1
            int middle = (length / 2) + 1; // 2^(n-1)

            if (k == middle) {
                return '1';
            } else if (k < middle) {
                return findKthBit(n - 1, k);
            } else {
                // Mirror position
                char bit = findKthBit(n - 1, length - k + 1);
                // Invert the bit
                return bit == '0' ? '1' : '0';
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new FindKthBitinNthBinaryString().new Solution();
        int n = 3;
        int k = 1;
        char result = solution.findKthBit(n, k);
        System.out.println(result); // Output: '0'
    }
}
