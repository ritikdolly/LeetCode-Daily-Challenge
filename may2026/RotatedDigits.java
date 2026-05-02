// Date:02-05-2026
// 788. Rotated Digits
// https://leetcode.com/problems/rotated-digits/description/?envType=daily-question&envId=2026-05-02

public class RotatedDigits {

    // method 1: brute force
    // class Solution {
    //     public int rotatedDigits(int n) {
    //         int count = 0;

    //         // Check every number from 1 to n
    //         for (int num = 1; num <= n; num++) {
    //             int x = num;
    //             boolean valid = true; // false if contains 3,4,7
    //             boolean changed = false; // true if contains 2,5,6,9

    //             while (x > 0) {
    //                 int digit = x % 10;

    //                 // Invalid digits after rotation
    //                 if (digit == 3 || digit == 4 || digit == 7) {
    //                     valid = false;
    //                     break;
    //                 }

    //                 // Digits that become different after rotation
    //                 if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
    //                     changed = true;
    //                 }

    //                 x /= 10;
    //             }

    //             // Good number: valid and changes to a different number
    //             if (valid && changed) {
    //                 count++;
    //             }
    //         }

    //         return count;
    //     }
    // }

    // method 2: optimized brute force
    class Solution {
        public int rotatedDigits(int n) {
            int count = 0;

            for (int i = 1; i <= n; i++) {
                if (isGood(i)) {
                    count++;
                }
            }
            return count;

        }

        private boolean isGood(int num) {
            boolean isDifferent = false;

            while (num > 0) {
                int digit = num % 10;
                num /= 10;

                if (digit == 3 || digit == 4 || digit == 7) {
                    return false;
                }
                if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    isDifferent = true;
                }
            }
            return isDifferent;
        }
    }

    public static void main(String[] args) {
        RotatedDigits.Solution solution = new RotatedDigits().new Solution();
        int n = 10;
        int result = solution.rotatedDigits(n);
        System.out.println(result); // Output: 4
    }
}
