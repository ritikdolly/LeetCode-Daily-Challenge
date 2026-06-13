// date:13-06-2026
// 3838. Weighted Word Mapping
// https://leetcode.com/problems/weighted-word-mapping/description/?envType=daily-question&envId=2026-06-13

public class WeightedWordMapping {
    class Solution {
        public String mapWordWeights(String[] words, int[] wt) {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                int s = 0;
                for (int i = 0; i < word.length(); i++)
                    s += wt[(word.charAt(i) & (1 << 5) - 1) - 1];

                sb.append((char) ('z' - (s - ((s * 2521) >> (1 << 4)) * 26)));
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new WeightedWordMapping().new Solution();
        String[] words = {"abc", "xyz", "hello"};
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        String result = solution.mapWordWeights(words, weights);
        System.out.println(result);
    }
}
