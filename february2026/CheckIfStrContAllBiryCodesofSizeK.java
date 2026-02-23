// Date: 23-02-2026
// 1461. Check If a String Contains All Binary Codes of Size K
// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/?envType=daily-question&envId=2026-02-23

import java.util.HashSet;

public class CheckIfStrContAllBiryCodesofSizeK {

    // method 1: using a HashSet to store unique substrings of length k and check
    // class Solution {

    //     public boolean hasAllCodes(String s, int k) {

    //         if (k > s.length())
    //             return false;

    //         HashSet<String> set = new HashSet<>();

    //         for (int i = 0; i <= s.length() - k; i++) {
    //             set.add(s.substring(i, i + k));
    //         }

    //         return set.size() == (1 << k); // 2^k
    //     }
    // }

    // method 2: using bit manipulation to create a hash for each substring of
    class Solution {

        public boolean hasAllCodes(String s, int k) {

            if (k > s.length())
                return false;

            int need = 1 << k; // total required codes
            boolean[] seen = new boolean[need];
            int count = 0;
            int hash = 0;

            for (int i = 0; i < s.length(); i++) {

                // Shift left and add current bit
                hash = ((hash << 1) & (need - 1)) | (s.charAt(i) - '0');

                // Start checking after first k-1 characters
                if (i >= k - 1) {
                    if (!seen[hash]) {
                        seen[hash] = true;
                        count++;
                    }
                }
            }

            return count == need;
        }
    }

    public static void main(String[] args) {
        Solution solution = new CheckIfStrContAllBiryCodesofSizeK().new Solution();
        String s = "00110110";
        int k = 2;
        boolean result = solution.hasAllCodes(s, k);
        System.out.println("Does the string contain all binary codes of size " + k + "? " + result);
    }
}
