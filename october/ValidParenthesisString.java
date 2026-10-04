// Date: 04-10-2026
// Problem title: 678. Valid Parenthesis String
//problem link: https://leetcode.com/problems/valid-parenthesis-string/description/?envType=daily-question&envId=2026-10-04

public class ValidParenthesisString {

    // Approch1 :  Greedy= Instead of deciding immediately what each '*' represents, maintain a range of possible open-parenthesis counts.
        // We maintain:
        // minOpen = minimum possible number of unmatched '('
        // maxOpen = maximum possible number of unmatched '('

    class Solution {
        public boolean checkValidString(String s) {

            int minOpen = 0;
            int maxOpen = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '(') {
                    minOpen++;
                    maxOpen++;
                }

                else if (ch == ')') {
                    minOpen--;
                    maxOpen--;
                }

                else { // '*'
                    minOpen--;
                    maxOpen++;
                }

                // Minimum cannot be negative
                if (minOpen < 0) {
                    minOpen = 0;
                }

                // Even the maximum possibility is invalid
                if (maxOpen < 0) {
                    return false;
                }
            }

            return minOpen == 0;
        }
    }
    public static void main(String[] args) {
        ValidParenthesisString obj = new ValidParenthesisString();
        Solution solution = obj.new Solution();

        String s1 = "()";
        System.out.println(solution.checkValidString(s1)); // Output: true

        String s2 = "(*)";
        System.out.println(solution.checkValidString(s2)); // Output: true

        String s3 = "(*))";
        System.out.println(solution.checkValidString(s3)); // Output: true

        String s4 = "(*()";
        System.out.println(solution.checkValidString(s4)); // Output: true

        String s5 = ")*(";
        System.out.println(solution.checkValidString(s5)); // Output: false
    }
}
