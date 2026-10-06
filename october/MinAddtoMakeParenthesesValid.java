// Date: 06-10-2026
// problem title: 921. Minimum Add to Make Parentheses Valid
//problem link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/?envType=daily-question&envId=2026-10-06

import java.util.Stack;

public class MinAddtoMakeParenthesesValid {
    // Approach 1: Using Stack
    // class Solution {
    // public int minAddToMakeValid(String s) {
    // Stack<Character> stack = new Stack<>();
    // for (int i = 0; i < s.length(); i++) {
    // if (s.charAt(i) == '(') {
    // stack.push('(');
    // } else {
    // if (stack.isEmpty() || stack.peek() == ')') {
    // stack.push(')');
    // } else {
    // stack.pop();
    // }
    // }
    // }
    // return (stack.size() == 0) ? 0 : stack.size();
    // }
    // }

    // Approach 2: Using Two Counters
    class Solution {
        public int minAddToMakeValid(String s) {
            int leftPar = 0;
            int ans = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    leftPar++;
                } else {
                    if (leftPar > 0) {
                        leftPar--;
                    } else {
                        ans++;
                    }
                }
            }
            return ans + leftPar;
        }
    }

    public static void main(String[] args) {
        MinAddtoMakeParenthesesValid mm = new MinAddtoMakeParenthesesValid();
        Solution solution = mm.new Solution();

        String s = "())";
        int minAdditions = solution.minAddToMakeValid(s);
        System.out.println("Minimum additions to make valid: " + minAdditions); // Output: 1
    }
}
