// date: 15-02-2026

// Title : 67 Add Binary
// https://leetcode.com/problems/add-binary/description/?envType=daily-question&envId=2026-02-15

public class AddBinary {

    // method 1 - Approach : Simulation
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder res = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;

            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0)
                    sum += a.charAt(i--) - '0';
                if (j >= 0)
                    sum += b.charAt(j--) - '0';
                carry = sum > 1 ? 1 : 0;
                res.append(sum % 2);
            }
            if (carry != 0)
                res.append(carry);
            return res.reverse().toString();
        }
    }

    // method 2 - Approach : Bit Manipulation
    // class Solution {
    //     public String addBinary(String a, String b) {

    //         StringBuilder res = new StringBuilder();
    //         int i = a.length() - 1;
    //         int j = b.length() - 1;
    //         int carry = 0;

    //         while (i >= 0 || j >= 0 || carry == 1) {

    //             int sum = carry;

    //             if (i >= 0)
    //                 sum += a.charAt(i--) - '0';
    //             if (j >= 0)
    //                 sum += b.charAt(j--) - '0';

    //             res.append(sum % 2);
    //             carry = sum / 2;
    //         }

    //         return res.reverse().toString();
    //     }
    // }

    public static void main(String[] args) {
        Solution sol = new AddBinary().new Solution();
        String a = "1010", b = "1011";
        System.out.println(sol.addBinary(a, b));
    }
}
