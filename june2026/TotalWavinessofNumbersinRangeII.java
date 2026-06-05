// Date: 05-06-2026
// 3753. Total Waviness of Numbers in Range II
// https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/description/?envType=daily-question&envId=2026-06-05
public class TotalWavinessofNumbersinRangeII {
    class Solution {
        static final int[] waves = new int[570];

        static {
            int j = 0;
            for (int i = 0; i < 1000; i++) {
                int r = i % 10;
                int m = (i / 10) % 10;
                int l = (i / 100) % 10;
                if ((m > Math.max(l, r)) | (m < Math.min(l, r)))
                    waves[j++] = i;
            }
        }

        public long totalWaviness(long A, long B) {
            return waveCount(B) - waveCount(A - 1);
        }

        private long waveCount(long num) {
            if (num < 100)
                return 0;
            long res = 0;
            for (int p : waves)
                res += countWays(num, p);
            return res;
        }

        private long countWays(long num, int pattern) {
            long type = pattern < 100 ? 1 : 0;
            long count = 0, mult = 1;

            for (int i = 0; mult * 100 <= num; i++) {
                long pre = num / (mult * 1000);
                long cur = (num / mult) % 1000;
                long suf = num % mult;
                long ways = 0;

                if (cur > pattern)
                    ways = pre - type + 1;
                else if (cur == pattern) {
                    ways = Math.max(0L, pre - type);
                    count += suf + 1;
                } else
                    ways = Math.max(0L, pre - type);

                count += ways * mult;
                mult *= 10;
            }

            return count;
        }
    }
    public static void main(String[] args) {
        Solution sol = new TotalWavinessofNumbersinRangeII().new Solution();
        long num1 = 1, num2 = 100;
        System.out.println(sol.totalWaviness(num1, num2)); // Output: 109
    }
}
