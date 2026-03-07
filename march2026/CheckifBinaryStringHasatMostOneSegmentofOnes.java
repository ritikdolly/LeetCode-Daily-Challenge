// Date : 06-03-2026
// 1784. Check if Binary String Has at Most One Segment of Ones
// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/?envType=daily-question&envId=2026-03-06

public class CheckifBinaryStringHasatMostOneSegmentofOnes {
    class Solution {
        public boolean checkOnesSegment(String s) {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        CheckifBinaryStringHasatMostOneSegmentofOnes solution = new CheckifBinaryStringHasatMostOneSegmentofOnes();
        String s = "1001";
        boolean result = solution.new Solution().checkOnesSegment(s);
        System.out.println(result); // Output: false
    }
}
