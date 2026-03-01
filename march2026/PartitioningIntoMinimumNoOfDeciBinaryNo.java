// Date: 01-03-2026
// 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/?envType=daily-question&envId=2026-03-01
public class PartitioningIntoMinimumNoOfDeciBinaryNo {
    class Solution {
        public int minPartitions(String n) {
            int maxDigit = 0;

            for (int i = 0; i < n.length(); i++) {
                int digit = n.charAt(i) - '0';
                maxDigit = Math.max(maxDigit, digit);

                // Early exit optimization
                if (maxDigit == 9) {
                    return 9;
                }
            }

            return maxDigit;
        }
}
    public static void main(String[] args) {
        Solution solution = new PartitioningIntoMinimumNoOfDeciBinaryNo().new Solution();
        String n = "32";
        int result = solution.minPartitions(n);
        System.out.println(result); // Output: 3
    }

}