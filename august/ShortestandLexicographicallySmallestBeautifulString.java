// Date: 26-08-2026
// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/?envType=daily-question&envId=2026-08-26
// 2904. Shortest and Lexicographically Smallest Beautiful String

public class ShortestandLexicographicallySmallestBeautifulString {
    class Solution {
        public String shortestBeautifulSubstring(String s, int k) {
            String ans = "";
            int n = s.length();

            for (int i = 0; i < n; i++) {

                int oneCnt = 0;
                StringBuilder cur = new StringBuilder();

                for (int j = i; j < n; j++) {

                    cur.append(s.charAt(j));

                    if (s.charAt(j) == '1')
                        oneCnt++;

                    // More than k ones can never become valid again
                    if (oneCnt > k)
                        break;

                    if (oneCnt == k) {
                        String curStr = cur.toString();

                        if (ans.isEmpty() ||
                                curStr.length() < ans.length() ||
                                (curStr.length() == ans.length() && curStr.compareTo(ans) < 0)) {

                            ans = curStr;
                        }
                    }
                }
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        ShortestandLexicographicallySmallestBeautifulString solution = new ShortestandLexicographicallySmallestBeautifulString();
        Solution sol = solution.new Solution();
        String s = "110100111";
        int k = 2;
        String result = sol.shortestBeautifulSubstring(s, k);
        System.out.println("The shortest beautiful substring is: " + result);
    }
}
