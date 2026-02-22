// Date : 22-02-2026
// 868. Binary Gap
// https://leetcode.com/problems/binary-gap/?envType=daily-question&envId=2026-02-22

public class BinaryGap {
    // method 1: using bit manipulation to find the positions of 1s and calculate the maximum distance
    class Solution {

        public int binaryGap(int n) {
            int maxDistance = 0;
            int lastPosition = -1;
            int position = 0;

            while (n > 0) {

                if ((n & 1) == 1) { // if last bit is 1
                    if (lastPosition != -1) {
                        maxDistance = Math.max(maxDistance, position - lastPosition);
                    }
                    lastPosition = position;
                }

                n = n >> 1; // right shift
                position++;
            }

            return maxDistance;
        }
    }
    public static void main(String[] args) {
        Solution solution = new BinaryGap().new Solution();
        int n = 22; // binary representation is 10110
        int result = solution.binaryGap(n);
        System.out.println("Maximum distance between two consecutive 1s: " + result);
    }
    
}
