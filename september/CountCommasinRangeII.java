// Date:09-09-2026
// Problem Title: 3871. Count Commas in Range II
// Problem Link: https://leetcode.com/problems/count-commas-in-range-ii/description/?envType=daily-question&envId=2026-09-09
public class CountCommasinRangeII {
    class Solution {
        public long countCommas(long n) {
            if (n < 1000)
                return 0;

            long totalCommas = 0;
            long rangeStart = 1000;
            long rangeEnd = rangeStart * 1000 - 1;
            int commas = 1;

            while (rangeStart <= n) {
                long numbers = Math.min(n, rangeEnd) - rangeStart + 1;
                totalCommas += (long) commas * numbers;

                if (rangeEnd > n)
                    break;

                rangeStart = rangeStart * 1000;
                rangeEnd = rangeStart * 1000 - 1;
                commas++;
            }
            return totalCommas;
        }
    }
    public static void main(String[] args) {
        CountCommasinRangeII solution = new CountCommasinRangeII();
        Solution countCommasSolution = solution.new Solution();

        // Test cases
        System.out.println(countCommasSolution.countCommas(999));   // Output: 0
        System.out.println(countCommasSolution.countCommas(1000));  // Output: 1
        System.out.println(countCommasSolution.countCommas(1500));  // Output: 501
        System.out.println(countCommasSolution.countCommas(2000));  // Output: 1001
        System.out.println(countCommasSolution.countCommas(1000000)); // Output: 1999001
    }
}
