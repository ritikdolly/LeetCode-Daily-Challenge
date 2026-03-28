// Date: 28-03-2026
// 2573. Find the String with LCP
// https://leetcode.com/problems/find-the-string-with-lcp/description/?envType=daily-question&envId=2026-03-28

public class FindtheStringwithLCP {

    // Method 1: Modify the matrix and compare
    // class Solution {
    //     public String findTheString(int[][] lcp) {
    //         int n = lcp.length;

    //         // Step 1: Validate diagonal
    //         for (int i = 0; i < n; i++) {
    //             if (lcp[i][i] != n - i)
    //                 return "";
    //         }

    //         // Step 2: DSU (Union-Find)
    //         int[] parent = new int[n];
    //         for (int i = 0; i < n; i++)
    //             parent[i] = i;

    //         // Find
    //         java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
    //             public int applyAsInt(int x) {
    //                 if (parent[x] != x)
    //                     parent[x] = applyAsInt(parent[x]);
    //                 return parent[x];
    //             }
    //         };

    //         // Union
    //         java.util.function.BiConsumer<Integer, Integer> union = (a, b) -> {
    //             int pa = find.applyAsInt(a);
    //             int pb = find.applyAsInt(b);
    //             if (pa != pb)
    //                 parent[pa] = pb;
    //         };

    //         // Step 3: Merge positions
    //         for (int i = 0; i < n; i++) {
    //             for (int j = i + 1; j < n; j++) {
    //                 if (lcp[i][j] > 0) {
    //                     union.accept(i, j);
    //                 }
    //             }
    //         }

    //         // Step 4: Assign characters
    //         char[] res = new char[n];
    //         java.util.Map<Integer, Character> map = new java.util.HashMap<>();
    //         char ch = 'a';

    //         for (int i = 0; i < n; i++) {
    //             int root = find.applyAsInt(i);
    //             if (!map.containsKey(root)) {
    //                 if (ch > 'z')
    //                     return ""; // cannot assign more than 26 chars
    //                 map.put(root, ch++);
    //             }
    //             res[i] = map.get(root);
    //         }

    //         String s = new String(res);

    //         // Step 5: Validate LCP matrix
    //         int[][] dp = new int[n + 1][n + 1];

    //         for (int i = n - 1; i >= 0; i--) {
    //             for (int j = n - 1; j >= 0; j--) {
    //                 if (s.charAt(i) == s.charAt(j)) {
    //                     dp[i][j] = 1 + dp[i + 1][j + 1];
    //                 }
    //             }
    //         }

    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 if (dp[i][j] != lcp[i][j]) {
    //                     return "";
    //                 }
    //             }
    //         }

    //         return s;
    //     }
    // }

    // Method 2: Compare expected values without modifying the matrix
    class Solution {
        public String findTheString(int[][] lcp) {
            int n = lcp.length;
            char[] word = new char[n];
            char current = 'a';

            // construct the string starting from 'a' to 'z' sequentially
            for (int i = 0; i < n; i++) {
                if (word[i] == 0) {
                    if (current > 'z') {
                        return "";
                    }
                    word[i] = current;
                    for (int j = i + 1; j < n; j++) {
                        if (lcp[i][j] > 0) {
                            word[j] = word[i];
                        }
                    }
                    current++;
                }
            }

            // verify if the constructed string meets the LCP matrix requirements
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (word[i] != word[j]) {
                        if (lcp[i][j] != 0) {
                            return "";
                        }
                    } else {
                        if (i == n - 1 || j == n - 1) {
                            if (lcp[i][j] != 1) {
                                return "";
                            }
                        } else {
                            if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
                                return "";
                            }
                        }
                    }
                }
            }

            return new String(word);
        }
    }
    public static void main(String[] args) {
        Solution sol = new FindtheStringwithLCP().new Solution();
        int[][] lcp = {
                { 4, 3, 2, 1 },
                { 3, 4, 3, 2 },
                { 2, 3, 4, 3 },
                { 1, 2, 3, 4 }
        };
        System.out.println(sol.findTheString(lcp)); // Output: "aaaa"
    }
}