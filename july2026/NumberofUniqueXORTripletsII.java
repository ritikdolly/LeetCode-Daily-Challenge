// Date: 24-07-2026
// problem: 3514. Number of Unique XOR Triplets II
// https://leetcode.com/problems/number-of-unique-xor-triplets-ii/description/?envType=daily-question&envId=2026-07-24
public class NumberofUniqueXORTripletsII {
    class Solution {
        public int uniqueXorTriplets(int[] nums) {
            final int MAX_XOR = 2048;

            boolean[] pairXor = new boolean[MAX_XOR];
            boolean[] tripletXor = new boolean[MAX_XOR];

            int n = nums.length;

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    pairXor[nums[i] ^ nums[j]] = true;
                }
            }

            for (int x = 0; x < MAX_XOR; x++) {
                if (!pairXor[x])
                    continue;

                for (int v : nums) {
                    tripletXor[x ^ v] = true;
                }
            }

            int count = 0;
            for (boolean exists : tripletXor) {
                if (exists)
                    count++;
            }

            return count;
        }
    }
    public static void main(String[] args) {
        //write a main method code.....
    }
}
