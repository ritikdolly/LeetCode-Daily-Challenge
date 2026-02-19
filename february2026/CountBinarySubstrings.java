// date: 19-02-2026
// 696. Count Binary Substrings
// https://leetcode.com/problems/count-binary-substrings/?envType=daily-question&envId=2026-02-19

public class CountBinarySubstrings {
    class Solution {
        public int countBinarySubstrings(String s) {
            int prev = 0, curr = 1, result = 0;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    curr++;
                } else {
                    result += Math.min(prev, curr);
                    prev = curr;
                    curr = 1;
                }
            }

            result += Math.min(prev, curr);
            return result;
        }
    }
    public static void main(String[] args) {
        Solution sol = new CountBinarySubstrings().new Solution();
        String s = "00110011";
        System.out.println(sol.countBinarySubstrings(s));
    }
}
