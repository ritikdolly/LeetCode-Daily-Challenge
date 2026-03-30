// Date: 29-03-2026
// 2839. Check if Strings Can be Made Equal With Operations I
// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/description/?envType=daily-question&envId=2026-03-29

import java.util.Arrays;

public class CheckifStringsCanbeMadeEqualWithOperationsI {

    class Solution {
        public boolean canBeEqual(String s1, String s2) {
            char[] a1 = { s1.charAt(0), s1.charAt(2) };
            char[] a2 = { s2.charAt(0), s2.charAt(2) };

            char[] b1 = { s1.charAt(1), s1.charAt(3) };
            char[] b2 = { s2.charAt(1), s2.charAt(3) };

            Arrays.sort(a1);
            Arrays.sort(a2);
            Arrays.sort(b1);
            Arrays.sort(b2);

            return Arrays.equals(a1, a2) && Arrays.equals(b1, b2);
        }

        public static void main(String[] args) {
            Solution sol = new CheckifStringsCanbeMadeEqualWithOperationsI().new Solution();
            System.out.println(sol.canBeEqual("abcd", "cdab")); // true
        }
    }
}