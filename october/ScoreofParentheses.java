// Date: 05-10-2026
// problem title: 856. Score of Parentheses
// problem link: https://leetcode.com/problems/score-of-parentheses/description/?envType=daily-question&envId=2026-10-05

import java.util.Stack;

class ScoreofParentheses {
    
    // Approach: Using Stack
    class Solution {
        public int scoreOfParentheses(String s) {
            Stack<Integer> st = new Stack<>();
            st.push(0);

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    st.push(0);
                } else {
                    int innerScore = st.pop();
                    int score = (innerScore == 0) ? 1 : 2 * innerScore;

                    st.push(st.pop() + score);
                }
            }
            return st.pop();
        }

    }

    public static void main(String[] args) {
        ScoreofParentheses sp = new ScoreofParentheses();
        Solution solution = sp.new Solution();

        String s = "(()(()))";
        int score = solution.scoreOfParentheses(s);
        System.out.println("Score of parentheses: " + score); // Output: 6
    }
}