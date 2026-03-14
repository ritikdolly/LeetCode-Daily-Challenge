// Date : 14-03-2026
// 1415. The k-th Lexicographical String of All Happy Strings of Length n
// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/?envType=daily-question&envId=2026-03-14

import java.util.ArrayList;
import java.util.List;

public class ThekthLexicographicalStrofAllHappyStrofLenN {

    // Method 1: Backtracking
    // class Solution {

    // public String getHappyString(int n, int k) {
    // List<String> list = new ArrayList<>();
    // backtrack("", n, list);

    // if (k > list.size())
    // return "";
    // return list.get(k - 1);
    // }

    // private void backtrack(String curr, int n, List<String> list) {
    // if (curr.length() == n) {
    // list.add(curr);
    // return;
    // }

    // for (char c : new char[] { 'a', 'b', 'c' }) {
    // if (curr.length() > 0 && curr.charAt(curr.length() - 1) == c)
    // continue;
    // backtrack(curr + c, n, list);
    // }
    // }
    // }

    // Method 2: Backtracking with Early Stopping
    class Solution {

        private static char[] ALLOWED_LETTERS = { 'a', 'b', 'c' };

        private int happyStringCount;
        private String kthHappyString;

        public String getHappyString(int n, int k) {
            this.happyStringCount = 0;
            this.kthHappyString = "";
            kthHappyStringHelper(new StringBuilder(), n, k);
            return happyStringCount >= k ? kthHappyString : "";
        }

        private void kthHappyStringHelper(StringBuilder currStr, int n, int k) {

            int currStrSize = currStr.length();

            if (currStrSize == n) {
                happyStringCount++;
                if (happyStringCount == k) {
                    kthHappyString = currStr.toString();
                }
                return;
            }

            for (char c : ALLOWED_LETTERS) {

                if (currStrSize > 0 && c == currStr.charAt(currStrSize - 1))
                    continue;

                currStr.append(c);
                kthHappyStringHelper(currStr, n, k);
                currStr.deleteCharAt(currStrSize);

                if (happyStringCount == k)
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new ThekthLexicographicalStrofAllHappyStrofLenN().new Solution();
        System.out.println(sol.getHappyString(1, 3)); // Output: "c"
        System.out.println(sol.getHappyString(1, 4)); // Output: ""
        System.out.println(sol.getHappyString(3, 9)); // Output: "cab"
    }
}
