// Date: 08-07-2026
// 3756. Concatenate Non-Zero Digits and Multiply by Sum II
// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/description/?envType=daily-question&envId=2026-07-08
public class ConcatenateNonZeroDigitsandMultiplybySumII {
    class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        long MOD = 1000000007L;

        long[] prefSum = new long[n + 1];
        long[] prefVal = new long[n + 1];
        int[] prefCnt = new int[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;

        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefSum[i + 1] = prefSum[i] + d;
            prefCnt[i + 1] = prefCnt[i] + (d != 0 ? 1 : 0);

            if (d == 0) {
                prefVal[i + 1] = prefVal[i];
            } else {
                prefVal[i + 1] = (prefVal[i] * 10 + d) % MOD;
            }
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int len = prefCnt[r + 1] - prefCnt[l];

            long start = prefVal[l];
            long end = prefVal[r + 1];

            long x = (end - (start * power[len]) % MOD + MOD) % MOD;
            long sum = prefSum[r + 1] - prefSum[l];

            result[i] = (int) ((x * sum) % MOD);
        }

        return result;
    }
}
    public static void main(String[] args) {
        ConcatenateNonZeroDigitsandMultiplybySumII outer = new ConcatenateNonZeroDigitsandMultiplybySumII();
        Solution solution = outer.new Solution();

        String s = "123405";
        int[][] queries = {{0, 5}, {1, 4}, {2, 3}};
        int[] result = solution.sumAndMultiply(s, queries);
        for (int res : result) {
            System.out.println(res);
        }
    }
    
}