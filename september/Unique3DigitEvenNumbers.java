// Date: 11-09-2026
// Problem title: 3483. Unique 3-Digit Even Numbers
// problem link: https://leetcode.com/problems/unique-3-digit-even-numbers/description/?envType=daily-question&envId=2026-09-11

import java.util.HashSet;
import java.util.Set;

public class Unique3DigitEvenNumbers {

    // Approach: Brute Force
    // class Solution {
    //     public int totalNumbers(int[] digits) {
    //         HashSet<Integer> map = new HashSet<>();
    //         int n = digits.length;

    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 for (int k = 0; k < n; k++) {
    //                     if (i != j && i != k && j != k) {
    //                         if (digits[i] != 0) {
    //                             if (digits[k] % 2 == 0) {
    //                                 int number = digits[i] * 100 + digits[j] * 10 + digits[k];
    //                                 map.add(number);
    //                             }
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //         return map.size();
    //     }
    // }

    // Approach: Backtracking
    class Solution {
        Set<Integer> st = new HashSet<>();

        void backtracking(int[] digits, int num, int digit, boolean[] used) {
            if (digit == 3) {
                if (num % 2 == 0) {
                    st.add(num);
                }
                return;
            }

            for (int i = 0; i < digits.length; i++) {
                if (used[i])
                    continue;

                if (digit == 0 && digits[i] == 0)
                    continue;

                used[i] = true;
                backtracking(digits, num * 10 + digits[i], digit + 1, used);
                used[i] = false;
            }
        }

        public int totalNumbers(int[] digits) {
            boolean[] used = new boolean[digits.length];
            backtracking(digits, 0, 0, used);
            return st.size();
        }
    }

    public static void main(String[] args) {
        Unique3DigitEvenNumbers solution = new Unique3DigitEvenNumbers();
        Solution totalNumbersSolution = solution.new Solution();

        // Test cases
        int[] digits1 = { 2, 1, 3, 0 };
        System.out.println(totalNumbersSolution.totalNumbers(digits1)); // Output: 6

        int[] digits2 = { 2, 2, 8, 8, 2 };
        System.out.println(totalNumbersSolution.totalNumbers(digits2)); // Output: 2

        int[] digits3 = { 3, 7, 5 };
        System.out.println(totalNumbersSolution.totalNumbers(digits3)); // Output: 0
    }
}
