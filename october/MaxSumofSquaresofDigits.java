// Date: 14-10-2026
//problem titles: 3723. Maximize Sum of Squares of Digits
// problem link: 

class MaxSumofSquaresofDigits {
    class Solution {
        public String maxSumOfSquares(int num, int sum) {
            if (sum > 9 * num) {
                return "";
            }

            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < num; i++) {
                int digit = Math.min(9, sum);
                ans.append(digit);
                sum -= digit;
            }

            return sum == 0 ? ans.toString() : "";
        }
    }
    public static void main(String[] args) {
        MaxSumofSquaresofDigits solution = new MaxSumofSquaresofDigits();
        Solution sol = solution.new Solution();

        int num = 3;
        int sum = 20;
        String result = sol.maxSumOfSquares(num, sum);
        System.out.println("Max Sum of Squares: " + result);
    }
}