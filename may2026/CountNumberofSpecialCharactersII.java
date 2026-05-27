// date: 27-05-2026
// 3121. Count the Number of Special Characters II
// https://leetcode.com/problems/count-the-number-of-special-characters-ii/?envType=daily-question&envId=2026-05-27
import java.util.Arrays;

public class CountNumberofSpecialCharactersII {
    // approach 1: using boolean arrays to track presence of lowercase and uppercase characters
    class Solution {
        public int numberOfSpecialChars(String word) {

            boolean[] lower = new boolean[26];
            boolean[] upper = new boolean[26];
            boolean[] special = new boolean[26];

            int count = 0;

            for (char ch : word.toCharArray()) {

                if (Character.isLowerCase(ch)) {

                    int idx = ch - 'a';

                    // lowercase after uppercase -> invalidate
                    if (upper[idx] && special[idx]) {
                        count--;
                        special[idx] = false;
                    }

                    lower[idx] = true;

                } else {

                    int idx = ch - 'A';

                    // first valid uppercase
                    if (lower[idx] && !upper[idx]) {
                        count++;
                        special[idx] = true;
                    }

                    upper[idx] = true;
                }
            }

            return count;
        }
    }

    // approach 2: using indices to track last lowercase and first uppercase positions
    // class Solution {
    //     public int numberOfSpecialChars(String word) {

    //         int[] lastLower = new int[26];
    //         int[] firstUpper = new int[26];

    //         Arrays.fill(lastLower, -1);
    //         Arrays.fill(firstUpper, -1);

    //         for (int i = 0; i < word.length(); i++) {

    //             char ch = word.charAt(i);

    //             if (Character.isLowerCase(ch)) {

    //                 lastLower[ch - 'a'] = i;

    //             } else {

    //                 int idx = ch - 'A';

    //                 if (firstUpper[idx] == -1) {
    //                     firstUpper[idx] = i;
    //                 }
    //             }
    //         }

    //         int count = 0;

    //         for (int i = 0; i < 26; i++) {

    //             if (lastLower[i] != -1 &&
    //                     firstUpper[i] != -1 &&
    //                     lastLower[i] < firstUpper[i]) {

    //                 count++;
    //             }
    //         }

    //         return count;
    //     }
    // }

    public static void main(String[] args) {
        Solution sol = new CountNumberofSpecialCharactersII().new Solution();
        String word = "aA";
        System.out.println(sol.numberOfSpecialChars(word)); // Output: 1
    }
}
