// Date: 07-10-2026
// problem title: 301. Remove Invalid Parentheses
// problem link: https://leetcode.com/problems/remove-invalid-parentheses/description/?envType=daily-question&envId=2026-10-07 

/**
 * RemoveInvalidParentheses
 */
import java.util.*;

public class RemoveInvalidParentheses {

    // Appproach 1: Using DFS
    class Solution {

        private List<String> result = new ArrayList<>();

        public List<String> removeInvalidParentheses(String s) {

            int leftRemove = 0;
            int rightRemove = 0;

            // Find the minimum number of '(' and ')' to remove
            for (char ch : s.toCharArray()) {

                if (ch == '(') {
                    leftRemove++;
                } else if (ch == ')') {

                    if (leftRemove > 0) {
                        leftRemove--;
                    } else {
                        rightRemove++;
                    }
                }
            }

            dfs(s, 0, leftRemove, rightRemove);

            return result;
        }

        private void dfs(String s, int start,
                int leftRemove, int rightRemove) {

            // We have removed the required number
            if (leftRemove == 0 && rightRemove == 0) {

                if (isValid(s)) {
                    result.add(s);
                }

                return;
            }

            for (int i = start; i < s.length(); i++) {

                // Avoid duplicate results
                if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                    continue;
                }

                // Remove '('
                if (leftRemove > 0 && s.charAt(i) == '(') {

                    String newString = s.substring(0, i) + s.substring(i + 1);

                    dfs(
                            newString,
                            i,
                            leftRemove - 1,
                            rightRemove);
                }

                // Remove ')'
                if (rightRemove > 0 && s.charAt(i) == ')') {

                    String newString = s.substring(0, i) + s.substring(i + 1);

                    dfs(
                            newString,
                            i,
                            leftRemove,
                            rightRemove - 1);
                }
            }
        }

        // Check whether parentheses are valid
        private boolean isValid(String s) {

            int balance = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '(') {
                    balance++;
                } else if (ch == ')') {
                    balance--;

                    // More ')' than '('
                    if (balance < 0) {
                        return false;
                    }
                }
            }

            // All '(' must have matching ')'
            return balance == 0;
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        Solution solution = rip.new Solution();

        String s = "()())()";
        List<String> validStrings = solution.removeInvalidParentheses(s);
        System.out.println("Valid strings after removing invalid parentheses: " + validStrings); // Output: ["()()()", "(())()"]
    }
}