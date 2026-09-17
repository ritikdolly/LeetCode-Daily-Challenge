// Date: 17-09-2026
// 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/?envType=daily-question&envId=2026-09-17

import java.util.Arrays;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
    // Approach: Sliding Window + Dynamic Programming
    class Solution {
        public int minSumOfLengths(int[] A, int k) {
            int n = A.length;
            int res = n + 1, sum = 0, i = 0;

            int[] dp = new int[n + 1];
            Arrays.fill(dp, n);

            for (int j = 0; j < n; j++) {
                sum += A[j];

                while (sum > k)
                    sum -= A[i++];

                dp[j + 1] = dp[j];

                if (sum == k) {
                    res = Math.min(res, j - i + 1 + dp[i]);
                    dp[j + 1] = Math.min(dp[j], j - i + 1);
                }
            }

            return res == n + 1 ? -1 : res;
        }
    }
    public static void main(String[] args) {
        Solution solution = new FindTwoNonoverlappingSubarraysEachWithTargetSum().new Solution();
        int[] A = {3, 2, 2, 4, 3};
        int k = 3;
        System.out.println(solution.minSumOfLengths(A, k)); // Output: 2
    }
}
