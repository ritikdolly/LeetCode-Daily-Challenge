// Date 21-02-2026
// 762. Prime Number of Set Bits in Binary Representation
// https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/?envType=daily-question&envId=2026-02-21

public class PrimeNoofSetBitsinBinaryRepre {

    // method 1: using bitCount and checking for prime numbers directly
    // class Solution {

    //     public int countPrimeSetBits(int left, int right) {
    //         int count = 0;

    //         for (int i = left; i <= right; i++) {
    //             int bits = Integer.bitCount(i);

    //             if (bits == 2 || bits == 3 || bits == 5 || bits == 7 ||
    //                     bits == 11 || bits == 13 || bits == 17 || bits == 19) {
    //                 count++;
    //             }
    //         }

    //         return count;
    //     }
    // }

    // method 2: using bitCount and a helper method to check for prime numbers
    class Solution {

        public int countPrimeSetBits(int left, int right) {
            int count = 0;

            for (int i = left; i <= right; i++) {
                int setBits = Integer.bitCount(i); // counts number of 1s

                if (isPrime(setBits)) {
                    count++;
                }
            }

            return count;
        }

        private boolean isPrime(int n) {
            if (n < 2)
                return false;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0)
                    return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new PrimeNoofSetBitsinBinaryRepre().new Solution();
        int left = 6, right = 10;
        int result = solution.countPrimeSetBits(left, right);
        System.out.println("Count of numbers with prime set bits: " + result);
    }

}