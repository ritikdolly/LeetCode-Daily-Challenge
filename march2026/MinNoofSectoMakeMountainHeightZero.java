// Date : 13-03-2026
// 3296. Minimum Number of Seconds to Make Mountain Height Zero
// https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/submissions/1947249767/?envType=daily-question&envId=2026-03-13
public class MinNoofSectoMakeMountainHeightZero {

    // Method 1: Binary Search with Nested Binary Search
    // class Solution {
    //     public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
    //         long left = 0;
    //         long right = (long) 1e18;
    //         long ans = right;

    //         while (left <= right) {
    //             long mid = left + (right - left) / 2;

    //             if (canReduce(mid, mountainHeight, workerTimes)) {
    //                 ans = mid;
    //                 right = mid - 1;
    //             } else {
    //                 left = mid + 1;
    //             }
    //         }

    //         return ans;
    //     }

    //     private boolean canReduce(long time, int height, int[] workers) {
    //         long total = 0;

    //         for (int w : workers) {
    //             long low = 0, high = (long) Math.sqrt(2.0 * time / w) + 2;

    //             while (low <= high) {
    //                 long mid = low + (high - low) / 2;
    //                 long cost = (long) w * mid * (mid + 1) / 2;

    //                 if (cost <= time) {
    //                     low = mid + 1;
    //                 } else {
    //                     high = mid - 1;
    //                 }
    //             }

    //             total += high;

    //             if (total >= height)
    //                 return true;
    //         }

    //         return total >= height;
    //     }
    // }

    // Method 2: Binary Search with Mathematical Calculation
    class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

            int max = 0;
            for (int x : workerTimes)
                max = Math.max(max, x);

            int h = (mountainHeight - 1) / workerTimes.length + 1;
            long left = 1, right = (long) max * h * (h + 1) / 2;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (check(mountainHeight, workerTimes, mid))
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            return left;
        }

        boolean check(int mountainHeight, int[] workerTimes, long time) {
            for (int x : workerTimes) {
                mountainHeight -= (int) (-1 + Math.sqrt(1 + 8 * time / x)) / 2;
                if (mountainHeight <= 0)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new MinNoofSectoMakeMountainHeightZero().new Solution();
        int mountainHeight = 10;
        int[] workerTimes = { 1, 2, 3 };
        long result = sol.minNumberOfSeconds(mountainHeight, workerTimes);
        System.out.println("Minimum number of seconds: " + result);
    }
}
