// Date: 25-02-2026
// 1356. Sort Integers by The Number of 1 Bits
// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/?envType=daily-question&envId=2026-02-25

import java.util.Arrays;

public class SortIntbyNoof1Bits {

    // 
    class Solution {
        public int[] sortByBits(int[] arr) {
            Integer[] nums = new Integer[arr.length];

            // Convert int[] to Integer[] (needed for custom sorting)
            for (int i = 0; i < arr.length; i++) {
                nums[i] = arr[i];
            }

            // Sort using custom comparator
            Arrays.sort(nums, (a, b) -> {
                int diff = Integer.bitCount(a) - Integer.bitCount(b);

                return diff != 0 ? diff : a - b; // Sort by bit count
            });

            // Convert back to int[]
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nums[i];
            }

            return arr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SortIntbyNoof1Bits().new Solution();
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] sortedArr = solution.sortByBits(arr);
        System.out.println(Arrays.toString(sortedArr)); // Output: [0, 1, 2, 4, 8, 3, 5, 6, 7]
    }
}
