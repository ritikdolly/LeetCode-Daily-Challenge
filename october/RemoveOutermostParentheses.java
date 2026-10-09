// Date: 08-10-2026
// problem title: 1021 Remove Outermost Parentheses
// problem link: https://leetcode.com/problems/remove-outermost-parentheses/description/?envType=daily-question&envId=2026-10-08

class RemoveOutermostParentheses {

    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder str = new StringBuilder();
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(') {
                    if (count > 0) {
                        str.append(ch);
                    }
                    count++;
                } else {
                    count--;
                    if (count > 0) {
                        str.append(ch);
                    }
                }
            }

            return str.toString();
        }
    }
    public static void main(String[] args) {
        RemoveOutermostParentheses outermostParentheses = new RemoveOutermostParentheses();
        Solution solution = outermostParentheses.new Solution();

        String s = "(()())(())";
        String result = solution.removeOuterParentheses(s);
        System.out.println(result); // Output: "()()()"
    }

}