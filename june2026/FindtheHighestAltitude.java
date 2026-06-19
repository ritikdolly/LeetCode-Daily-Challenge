// Date- 19-06-2026
// 1732. Find the Highest Altitude
// https://leetcode.com/problems/find-the-highest-altitude/description/?envType=daily-question&envId=2026-06-19

public class FindtheHighestAltitude {
    // Approach 1: Use prefix sum to calculate the altitude at each point and keep track of the maximum altitude encountered. The prefix sum array will store the cumulative gain at each index, allowing us to easily find the highest altitude by iterating through the prefix sum array.
    // class Solution {
    //     public int largestAltitude(int[] gain) {
    //         int n = gain.length;
    //         int mx = 0;

    //         for (int i = 0; i <= n; i++) {
    //             int alt = 0;
    //             for (int j = 0; j < i; j++) {
    //                 alt += gain[j];
    //             }
    //             mx = Math.max(mx, alt);
    //         }

    //         return mx;
    //     }
    // }

    // Approach 2: Use prefix sum to calculate the altitude at each point and keep track of the maximum altitude encountered. The prefix sum array will store the cumulative gain at each index, allowing us to easily find the highest altitude by iterating through the prefix sum array.
    class Solution {
        public int largestAltitude(int[] arr) {

            int prefixSum[] = new int[arr.length + 1];
            prefixSum[0] = 0;
            for (int i = 1; i <= arr.length; i++)
                prefixSum[i] = prefixSum[i - 1] + arr[i - 1];

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < prefixSum.length; i++)
                res = Math.max(prefixSum[i], res);

            return res;

        }
    }

    public static void main(String[] args) {
        FindtheHighestAltitude obj = new FindtheHighestAltitude();
        Solution solution = obj.new Solution();

        int[] gain = { -5, 1, 5, 0, -7 };
        int result = solution.largestAltitude(gain);
        System.out.println(result); // Output: 1
    }
}
