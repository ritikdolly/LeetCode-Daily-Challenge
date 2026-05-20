// Date: 20-05-2026
// 2657. Find the Prefix Common Array of Two Arrays
// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/?envType=daily-question&envId=2026-05-20

public class FindPrefixCommonArrayofTwoArr {
    class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            int n = A.length, count = 0;
            int[] res = new int[n];
            boolean[] seen = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (seen[A[i] - 1])
                    count++;
                else
                    seen[A[i] - 1] = true;

                if (seen[B[i] - 1])
                    count++;
                else
                    seen[B[i] - 1] = true;

                res[i] = count;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        FindPrefixCommonArrayofTwoArr m = new FindPrefixCommonArrayofTwoArr();
        Solution s = m.new Solution();

        int[] A = { 2, 3, 1 };
        int[] B = { 3, 1, 2 };

        int[] ans = s.findThePrefixCommonArray(A, B);

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}