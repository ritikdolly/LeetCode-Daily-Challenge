// Date 27-03-2026
// 2946. Matrix Similarity After Cyclic Shifts
// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/?envType=daily-question&envId=2026-03-27

import java.util.*;

public class MatrixSimilarityAfterCyclicShifts {

    // Method 1: Shift and compare
    // class Solution {
    // void reverse(int[] arr, int left, int right) {
    // while (left < right) {
    // int temp = arr[left];
    // arr[left++] = arr[right];
    // arr[right--] = temp;
    // }
    // }

    // void leftShift(int[] arr, int k) {
    // reverse(arr, 0, k - 1);
    // reverse(arr, k, arr.length - 1);
    // reverse(arr, 0, arr.length - 1);
    // }

    // void rightShift(int[] arr, int k) {
    // reverse(arr, 0, arr.length - 1);
    // reverse(arr, 0, k - 1);
    // reverse(arr, k, arr.length - 1);
    // }

    // public boolean areSimilar(int[][] mat, int k) {
    // int m = mat.length;
    // int n = mat[0].length;
    // k %= n;
    // for (int i = 0; i < m; i++) {
    // int[] nums = Arrays.copyOf(mat[i], n);
    // if (i % 2 == 0) {
    // leftShift(nums, k);
    // } else {
    // rightShift(nums, k);
    // }

    // if (!Arrays.equals(mat[i], nums)) {
    // return false;
    // }
    // }
    // return true;
    // }
    // }

    // Method 2: Compare expected values without modifying the matrix
    // class Solution {
    //     public boolean areSimilar(int[][] mat, int k) {
    //         int m = mat.length;
    //         int n = mat[0].length;
    //         k %= n;

    //         for (int i = 0; i < m; i++) {
    //             for (int j = 0; j < n; j++) {

    //                 int expected;

    //                 if (i % 2 == 0) {
    //                     // left shift
    //                     expected = mat[i][(j + k) % n];
    //                 } else {
    //                     // right shift
    //                     expected = mat[i][(j - k + n) % n];
    //                 }

    //                 if (mat[i][j] != expected) {
    //                     return false;
    //                 }
    //             }
    //         }
    //         return true;
    //     }
    // }

    // Method 3: Compare expected values without modifying the matrix (optimized)
    class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;
            k = k % n;
            if (k == 0)
                return true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != mat[i][(j - k + n) % n]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new MatrixSimilarityAfterCyclicShifts().new Solution();
        solution.areSimilar(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 1);
        System.out.println(solution.areSimilar(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 1));
    }
}
