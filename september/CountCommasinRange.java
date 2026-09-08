// Date: 08-09-2026
// Problem Title: 3870. Count Commas in Range
// Problem Link: https://leetcode.com/problems/count-commas-in-range/description/?envType=daily-question&envId=2026-09-08

public class CountCommasInRange {

    // Approach 1: Brute Force
    // Iterate through every number from 1 to n.
    // Every number greater than or equal to 1000 contains at least one comma.
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    // class Solution {
    //     public int countCommas(int n) {
    //         int count = 0;

    //         for (int i = 1; i <= n; i++) {
    //             if (i >= 1000) {
    //                 count++;
    //             }
    //         }

    //         return count;
    //     }
    // }


    // Approach 2: Using Mathematical Formula
    // If n is less than 1000, no number contains a comma.
    // Otherwise, all numbers from 1000 to n contain at least one comma.
    // Number of such values = n - 999.
    // Time Complexity: O(1)
    // Space Complexity: O(1)

    // class Solution {
    //     public int countCommas(int n) {
    //         if (n < 1000) {
    //             return 0;
    //         }

    //         return n - 999;
    //     }
    // }


    // Approach 3: Using Range Counting
    // If n is less than 1000, return 0.
    // Otherwise, count the numbers in the range [1000, n].
    // Number of elements = (n - 1000) + 1.
    // Time Complexity: O(1)
    // Space Complexity: O(1)

    class Solution {
        public int countCommas(int n) {
            if (n < 1000) {
                return 0;
            }

            return (n - 1000) + 1;
        }
    }


    public static void main(String[] args) {
        idCountCommasInRange obj = new idCountCommasInRange();
        Solution solution = obj.new Solution();

        int n = 2500;

        int result = solution.countCommas(n);

        System.out.println("The number of commas is: " + result);
    }

}
