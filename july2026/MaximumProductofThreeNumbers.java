// Date: 26-07-2026
//  problem: 628. Maximum Product of Three Numbers
// https://leetcode.com/problems/maximum-product-of-three-numbers/description/?envType=daily-question&envId=2026-07-26

import java.util.Arrays;

public class MaximumProductofThreeNumbers {

    // Approach 1: Sort the array and calculate the maximum product of three numbers
    // class Solution {
    //     public int maximumProduct(int[] A) {
    //         Arrays.sort(A);
    //         int n = A.length;
    //         return Math.max(
    //                 A[n - 1] * A[n - 2] * A[n - 3],
    //                 A[n - 1] * A[0] * A[1]);
    //     }
    // }

    // Approach 2: Find the three largest and two smallest numbers in a single pass
    class Solution {
        public int maximumProduct(int[] A) {
            int a = -1001, b = a, c = b;
            int x = 1001, y = x;

            for (int n : A) {
                int pa = a, pb = b, px = x;

                a = Math.max(a, n);
                b = Math.max(b, Math.min(pa, n));
                c = Math.max(c, Math.min(pb, n));

                x = Math.min(x, n);
                y = Math.min(y, Math.max(px, n));
            }

            return Math.max(a * b * c, a * x * y);
        }
    }

    public static void main(String[] args) {
        Solution solution = new MaximumProductofThreeNumbers().new Solution();
        int[] nums = { 1, 2, 3, 4 };
        int result = solution.maximumProduct(nums);
        System.out.println("Maximum product of three numbers: " + result);

    }
}
