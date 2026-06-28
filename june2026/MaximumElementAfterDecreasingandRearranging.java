// Date: 28-06-2026
// problem: 1846. Maximum Element After Decreasing and Rearranging
// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/?envType=daily-question&envId=2026-06-28
import java.util.Arrays;

public class MaximumElementAfterDecreasingandRearranging {
    // Approach: Array is sorted in ascending order, and the first element is set to 1. Then, for each subsequent element, it is set to the minimum of its current value and the previous element plus 1. Finally, the last element of the array is returned as the maximum element after decreasing and rearranging.
    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

            Arrays.sort(arr);

            arr[0] = 1;

            for (int i = 1; i < arr.length; i++) {

                arr[i] = Math.min(arr[i], arr[i - 1] + 1);
            }

            return arr[arr.length - 1];
        }
    }
    
    public static void main(String[] args) {
        MaximumElementAfterDecreasingandRearranging solution = new MaximumElementAfterDecreasingandRearranging();
        Solution sol = solution.new Solution();

        int[] arr1 = {2, 2, 1, 2, 1};
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(arr1)); // Output: 2

        int[] arr2 = {100, 1, 1000};
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(arr2)); // Output: 3

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(arr3)); // Output: 5
    }
}
