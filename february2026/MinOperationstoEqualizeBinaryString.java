// Date: 27-02-2026
// 1405. Minimum Operations to Equalize a Binary String
// https://leetcode.com/problems/minimum-operations-to-equalize-binary-string/description/?envType=daily-question&envId=2026-02-27
public class MinOperationstoEqualizeBinaryString {
    class Solution {
        public int minOperations(String s, int k) {
            int n = s.length();
            int zero = 0;

            for (char c : s.toCharArray())
                if (c == '0')
                    zero++;

            if (zero == 0)
                return 0;

            if (n == k) {
                if (zero == n)
                    return 1;
                if (zero == 0)
                    return 0;
                return -1;
            }

            int one = n - zero;
            int base = n - k;

            long ans = Long.MAX_VALUE;

            if ((k % 2) == (zero % 2)) {
                long m = Math.max(
                        (zero + k - 1) / k,
                        (one + base - 1) / base);

                if (m % 2 == 0)
                    m++;

                ans = Math.min(ans, m);
            }

            if (zero % 2 == 0) {
                long m = Math.max(
                        (zero + k - 1) / k,
                        (zero + base - 1) / base);

                if (m % 2 == 1)
                    m++;

                ans = Math.min(ans, m);
            }

            return ans == Long.MAX_VALUE ? -1 : (int) ans;
        }
    }
    public static void main(String[] args) {
        Solution solution = new MinOperationstoEqualizeBinaryString().new Solution();
        String s = "1100";
        int k = 2;
        int result = solution.minOperations(s, k);
        System.out.println(result); // Output: 1
    }
}
