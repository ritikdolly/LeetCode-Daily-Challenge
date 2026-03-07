// Date: 07-03-2026
// 1888. Minimum Number of Flips to Make the Binary String Alternating
// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/?envType=daily-question&envId=2026-03-07
public class MinNoofFlipstoMakeBinaryStrAlternating {
    class Solution {
        public int minFlips(String s) {
            int n = s.length();
            String doubled = s + s;

            StringBuilder alt1 = new StringBuilder();
            StringBuilder alt2 = new StringBuilder();

            for (int i = 0; i < 2 * n; i++) {
                alt1.append(i % 2 == 0 ? '0' : '1');
                alt2.append(i % 2 == 0 ? '1' : '0');
            }

            int res = Integer.MAX_VALUE;
            int diff1 = 0, diff2 = 0;
            int l = 0;

            for (int r = 0; r < 2 * n; r++) {

                if (doubled.charAt(r) != alt1.charAt(r))
                    diff1++;
                if (doubled.charAt(r) != alt2.charAt(r))
                    diff2++;

                if (r - l + 1 > n) {
                    if (doubled.charAt(l) != alt1.charAt(l))
                        diff1--;
                    if (doubled.charAt(l) != alt2.charAt(l))
                        diff2--;
                    l++;
                }

                if (r - l + 1 == n) {
                    res = Math.min(res, Math.min(diff1, diff2));
                }
            }

            return res;
        }
    }
    public static void main(String[] args) {
        MinNoofFlipstoMakeBinaryStrAlternating solution = new MinNoofFlipstoMakeBinaryStrAlternating();
        String s = "111000";
        int result = solution.new Solution().minFlips(s);
        System.out.println(result); // Output: 2
    }
}
