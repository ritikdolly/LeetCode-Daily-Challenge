// Date:12-09-2026
// problem title: 3414. Maximum Score of Non-overlapping Intervals
// problem link: https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/description/?envType=daily-question&envId=2026-09-12

import java.util.*;

public class MaximuScoreofNonoverlappingIntervals {

    // Approach: Dynamic Programming + Binary Search
    class Solution {

        static class Node {
            long score;
            int[] indices;

            Node(long score, int[] indices) {
                this.score = score;
                this.indices = indices;
            }
        }

        public int[] maximumWeight(List<List<Integer>> intervals) {

            int n = intervals.size();

            // {end, start, weight, originalIndex}
            int[][] arr = new int[n][4];

            for (int i = 0; i < n; i++) {
                arr[i][0] = intervals.get(i).get(1); // end
                arr[i][1] = intervals.get(i).get(0); // start
                arr[i][2] = intervals.get(i).get(2); // weight
                arr[i][3] = i; // original index
            }

            // Sort by end time
            Arrays.sort(arr, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }

                return Integer.compare(a[3], b[3]);
            });

            /*
             * dp[i][k]:
             * Best answer using first i intervals
             * and selecting at most k intervals.
             */
            Node[][] dp = new Node[n + 1][5];

            // Base case
            for (int k = 0; k <= 4; k++) {
                dp[0][k] = new Node(0, new int[0]);
            }

            for (int i = 1; i <= n; i++) {

                dp[i][0] = new Node(0, new int[0]);

                for (int k = 1; k <= 4; k++) {

                    // Option 1: Skip current interval
                    Node skip = dp[i - 1][k];

                    // Option 2: Take current interval
                    int prev = findPrevious(arr, i - 1);

                    Node previous = dp[prev + 1][k - 1];

                    long newScore = previous.score + arr[i - 1][2];

                    int[] newIndices = new int[previous.indices.length + 1];

                    for (int j = 0; j < previous.indices.length; j++) {
                        newIndices[j] = previous.indices[j];
                    }

                    newIndices[previous.indices.length] = arr[i - 1][3];

                    // Keep indices sorted
                    Arrays.sort(newIndices);

                    Node take = new Node(newScore, newIndices);

                    dp[i][k] = better(skip, take);
                }
            }

            return dp[n][4].indices;
        }

        /*
         * Find the last interval whose:
         *
         * end < current.start
         *
         * Strictly less than is important because
         * intervals sharing an endpoint overlap.
         */
        private int findPrevious(int[][] arr, int current) {

            int start = arr[current][1];

            int low = 0;
            int high = current - 1;

            int ans = -1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (arr[mid][0] < start) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return ans;
        }

        /*
         * Compare two answers.
         *
         * 1. Higher score wins.
         * 2. If score is same, lexicographically smaller
         * index array wins.
         */
        private Node better(Node a, Node b) {

            if (a.score > b.score) {
                return a;
            }

            if (b.score > a.score) {
                return b;
            }

            if (lexicographicallySmaller(a.indices, b.indices)) {
                return a;
            }

            return b;
        }

        private boolean lexicographicallySmaller(
                int[] a, int[] b) {

            int n = Math.min(a.length, b.length);

            for (int i = 0; i < n; i++) {

                if (a[i] < b[i]) {
                    return true;
                }

                if (a[i] > b[i]) {
                    return false;
                }
            }

            return a.length < b.length;
        }
    }

    public static void main(String[] args) {
        MaximuScoreofNonoverlappingIntervals outer = new MaximuScoreofNonoverlappingIntervals();
        Solution solution = outer.new Solution();

        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(1, 3, 4));
        intervals.add(Arrays.asList(2, 5, 2));
        intervals.add(Arrays.asList(4, 6, 3));
        intervals.add(Arrays.asList(7, 8, 5));

        int[] result = solution.maximumWeight(intervals);
        System.out.println(Arrays.toString(result)); // Output the result
    }
}