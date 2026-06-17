// Date:17-06-2026
// 3614. Process String with Special Operations II
// https://leetcode.com/problems/process-string-with-special-operations-ii/description/?envType=daily-question&envId=2026-06-17

public class ProcessStringwithSpecialOperationsII {
    class Solution {
        public char processStr(String s, long k) {
            long len = 0;

            // Step 1
            for (char c : s.toCharArray()) {
                if (c == '*')
                    len = Math.max(0, len - 1);
                else if (c == '#')
                    len *= 2;
                else if (c != '%')
                    len++;
            }

            if (k >= len)
                return '.';

            // Step 2
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);

                if (c == '*')
                    len++;

                else if (c == '#') {
                    long half = len / 2;
                    if (k >= half)
                        k -= half;
                    len = half;
                }

                else if (c == '%') {
                    k = len - 1 - k;
                }

                else {
                    if (k == len - 1)
                        return c;
                    len--;
                }
            }

            return '.';
        }
    }
    public static void main(String[] args) {
        ProcessStringwithSpecialOperationsII obj = new ProcessStringwithSpecialOperationsII();
        Solution solution = obj.new Solution();

        String s = "a#b*c%de";
        long k = 3;
        char result = solution.processStr(s, k);
        System.out.println(result); // Output: 'b'
    }

}