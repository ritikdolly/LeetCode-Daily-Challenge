// Date:21-05-2026
// 3043. Find the Length of the Longest Common Prefix
// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/?envType=daily-question&envId=2026-05-21
public class FindtheLengthofLongestCommonPrefix {
    class Solution {

        class Node {
            Node[] child;
            boolean isEnd;

            Node() {
                child = new Node[10];
                isEnd = false;
            }
        }

        void insert(String word, Node root) {
            Node temp = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - '0';

                if (temp.child[idx] == null) {
                    temp.child[idx] = new Node();
                }

                temp = temp.child[idx];
            }

            temp.isEnd = true;
        }

        int check(String str, Node root) {
            Node temp = root;
            int idx = 0;

            while (idx < str.length()) {
                int i = str.charAt(idx) - '0';

                if (temp.child[i] != null) {
                    temp = temp.child[i];
                    idx++;
                } else {
                    break;
                }
            }

            return idx;
        }

        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Node root = new Node();

            for (int x : arr2) {
                insert(String.valueOf(x), root);
            }

            int ans = 0;

            for (int x : arr1) {
                ans = Math.max(ans, check(String.valueOf(x), root));
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        FindtheLengthofLongestCommonPrefix m = new FindtheLengthofLongestCommonPrefix();
        Solution s = m.new Solution();

        int[] arr1 = { 123, 456, 789 };
        int[] arr2 = { 123, 654, 321 };

        System.out.println(s.longestCommonPrefix(arr1, arr2));
    }
}
