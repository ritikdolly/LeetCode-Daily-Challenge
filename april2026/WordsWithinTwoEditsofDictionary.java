// Date: 22-04-2026
// 2452. Words Within Two Edits of Dictionary
// https://leetcode.com/problems/words-within-two-edits-of-dictionary/description/?envType=daily-question&envId=2026-04-22

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsofDictionary {
    class Solution {

        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> ans = new ArrayList<>();
            for (String query : queries) {
                for (String s : dictionary) {
                    int dis = 0;
                    for (int i = 0; i < query.length(); i++) {
                        if (query.charAt(i) != s.charAt(i)) {
                            dis++;
                        }
                    }
                    if (dis <= 2) {
                        ans.add(query);
                        break;
                    }
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution sol = new WordsWithinTwoEditsofDictionary().new Solution();
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};
        System.out.println(sol.twoEditWords(queries, dictionary));
    }
}
