// Date:16-11-2026
// problem title: 2243. Calculate Digit Sum of a String
// problem link: https://leetcode.com/problems/calculate-digit-sum-of-a-string/description/?envType=daily-question&envId=2026-11-16

public class CalculateDigitSumofString {

    // Approach 1: using recursion 
    // class Solution {

    //     int sumOfDigit(String str) {
    //         int sum = 0;

    //         for (int i = 0; i < str.length(); i++) {
    //             sum += str.charAt(i) - '0';
    //         }

    //         return sum;
    //     }

    //     String divide(String s, int k) {

    //         if (s.length() <= k) {
    //             return s;
    //         }

    //         StringBuilder newNum = new StringBuilder();

    //         for (int i = 0; i < s.length(); i += k) {

    //             int end = Math.min(i + k, s.length());

    //             String str = s.substring(i, end);

    //             newNum.append(sumOfDigit(str));
    //         }

    //         return divide(newNum.toString(), k);
    //     }

    //     public String digitSum(String s, int k) {
    //         return divide(s, k);
    //     }
    // }

    // Approach 2: using iteration
    class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i += k) {
                    int sum = 0;
                    for (int j = i; j < Math.min(i + k, s.length()); j++) {
                        sum += s.charAt(j) - '0';
                    }
                    sb.append(sum);
                }
                s = sb.toString();
            }
            return s;
        }
    }
    public static void main(String[] args) {
        CalculateDigitSumofString obj = new CalculateDigitSumofString();
        Solution solution = obj.new Solution();
        String s = "11111222223";
        int k = 3;
        String result = solution.digitSum(s, k);
        System.out.println(result); // Output: "135"
    }

}