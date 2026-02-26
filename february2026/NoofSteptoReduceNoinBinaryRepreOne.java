// Date : 27-02-2026
// 1404. Number of Steps to Reduce a Number in Binary Representation to One
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/?envType=daily-question&envId=2026-02-26

public class NoofSteptoReduceNoinBinaryRepreOne {
    class Solution {
        public int numSteps(String s) {
            int steps = 0;
            int carry = 0;

            for (int i = s.length() - 1; i > 0; i--) {

                int bit = (s.charAt(i) - '0') + carry;

                if (bit % 2 == 0) {
                    steps += 1;
                } else {
                    steps += 2;
                    carry = 1;
                }
            }

            return steps + carry;
        }
    }
    public static void main(String[] args) {
        Solution solution = new NoofSteptoReduceNoinBinaryRepreOne().new Solution();
        String s = "1101";
        int steps = solution.numSteps(s);
        System.out.println(steps); // Output: 6
    }
}
