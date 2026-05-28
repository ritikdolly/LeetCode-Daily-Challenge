// Date: 28-05-2026
// 3093. Longest Common Suffix Queries
// https://leetcode.com/problems/longest-common-suffix-queries/description/?envType=daily-question&envId=2026-05-28
public class LongestCommonSuffixQueries {
    class TrieNode {
        int index;
        int length;
        TrieNode[] children;

        TrieNode() {
            index = -1;
            length = Integer.MAX_VALUE;
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String str, int idx) {
            TrieNode node = root;
            int strlen = str.length();

            for (int i = strlen - 1; i >= 0; i--) {
                int ch = str.charAt(i) - 'a';
                if (node.children[ch] == null) {
                    node.children[ch] = new TrieNode();
                }
                node = node.children[ch];

                if (strlen < node.length) {
                    node.length = strlen;
                    node.index = idx;
                }
            }
        }

        int prefix(String query) {
            TrieNode node = root;
            int ans = -1;
            for (int i = query.length() - 1; i >= 0; i--) {
                int ch = query.charAt(i) - 'a';
                if (node.children[ch] == null) {
                    break;
                }
                node = node.children[ch];
                ans = node.index;
            }
            return ans;
        }

    }

    class Solution {
        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            Trie trie = new Trie();
            int idx = -1;
            int smallest = Integer.MAX_VALUE;

            for (int i = 0; i < wordsContainer.length; i++) {
                trie.insert(wordsContainer[i], i);
                if (wordsContainer[i].length() < smallest) {
                    idx = i;
                    smallest = wordsContainer[i].length();
                }
            }

            int[] ans = new int[wordsQuery.length];
            for (int i = 0; i < wordsQuery.length; i++) {
                int ind = trie.prefix(wordsQuery[i]);
                ans[i] = (ind == -1) ? idx : ind;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new LongestCommonSuffixQueries().new Solution();
        String[] wordsContainer = { "hello", "world", "hold" };
        String[] wordsQuery = { "lo", "ld", "o" };
        int[] ans = sol.stringIndices(wordsContainer, wordsQuery);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
