// Date: 03-05-2026
// 796. Rotate String
// https://leetcode.com/problems/rotate-string/description/?envType=daily-question&envId=2026-05-03

public class RotateString {

    class Solution {
        public boolean rotateString(String s, String goal) {
            // Lengths must match
            if (s.length() != goal.length()) {
                return false;
            }

            // If goal is a rotation of s, it must be a substring of s+s
            String doubled = s + s;
            return doubled.contains(goal);
        }
    }
    public static void main(String[] args) {
        RotateString rs = new RotateString();
        Solution solution = rs.new Solution();

        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println(solution.rotateString(s1, goal1)); // true

        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println(solution.rotateString(s2, goal2)); // false
    }
}