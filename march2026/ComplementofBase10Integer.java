// Date: 11-03-2026
// 1009. Complement of Base 10 Integer
// https://leetcode.com/problems/complement-of-base-10-integer/description/?envType
public class ComplementofBase10Integer {
    // Method 1: Using string manipulation
    // class Solution {
    //     public int bitwiseComplement(int n) {
    //         String binaryString = Integer.toBinaryString(n);
    //         StringBuilder complementStr = new StringBuilder();

    //         for (char ch : binaryString.toCharArray()) {
    //             complementStr.append(ch == '0' ? '1' : '0');
    //         }

    //         int decimalNumber = Integer.parseInt(complementStr.toString(), 2);
    //         return decimalNumber;
    //     }
    // }

    // Method 2: Using bit manipulation
    class Solution {
        public int bitwiseComplement(int n) {
            if (n == 0) {
                return 1; // The complement of 0 is 1
            }
            int mask = 1;
            while (mask <= n) {
                mask <<= 1; // Shift left to create a mask with all bits set to 1 up to the highest bit of n
            }
            return (mask - 1) ^ n; // XOR with n to get the complement
        }
    }  
    public static void main(String[] args) {
        ComplementofBase10Integer solution = new ComplementofBase10Integer();
        int n = 5;
        int result = solution.new Solution().bitwiseComplement(n);
        System.out.println(result); // Output: 2
    } 
}
