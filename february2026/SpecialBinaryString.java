// Date : 20-02-2026
// 761. Special Binary String
// https://leetcode.com/problems/special-binary-string/description/?envType=daily-question&envId=2026-02-20

import java.util.*;

public class SpecialBinaryString {

    class Solution {
        public String makeLargestSpecial(String s) {
            List<String> list = new ArrayList<>();
            int count = 0;
            int start = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                } else {
                    count--;
                }

                // When count becomes zero, we found a special substring
                if (count == 0) {
                    // Recursively solve inner part
                    String inner = makeLargestSpecial(s.substring(start + 1, i));
                    list.add("1" + inner + "0");
                    start = i + 1;
                }
            }

            // Sort in descending order
            Collections.sort(list, Collections.reverseOrder());

            // Combine all parts
            StringBuilder result = new StringBuilder();
            for (String str : list) {
                result.append(str);
            }

            return result.toString();
        }
    }
    public static void main(String[] args) {
        Solution sol = new SpecialBinaryString().new Solution();
        String s = "11011000";
        System.out.println(sol.makeLargestSpecial(s));
    }
}
