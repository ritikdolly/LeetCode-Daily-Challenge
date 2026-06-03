// Date: 03-06-2026
// 3635. Earliest Finish Time for Land and Water Rides II
// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/description/?envType=daily-question&envId=2026-06-03

public class EarliestFinishTimeforLandandWaterRidesII {
    class Solution {
        final static int MAX = 300005;

        public int earliestFinishTime(int[] la, int[] lb, int[] wa, int[] wb) {
            int l = MAX, w = MAX, minL = MAX, minW = MAX;
            int n = la.length, m = wa.length;

            for (int i = 0; i < n; ++i)
                l = Math.min(l, la[i] + lb[i]);

            for (int i = 0; i < m; ++i) {
                w = Math.min(w, wa[i] + wb[i]);
                minL = Math.min(minL, Math.max(wa[i], l) + wb[i]);
            }

            for (int i = 0; i < n; ++i)
                minW = Math.min(minW, Math.max(la[i], w) + lb[i]);

            return Math.min(minW, minL);
        }
}
    public static void main(String[] args) {
        Solution sol = new EarliestFinishTimeforLandandWaterRidesII().new Solution();
        int[] landStartTime = { 1, 2, 3 };
        int[] landDuration = { 3, 2, 1 };
        int[] waterStartTime = { 2, 3, 4 };
        int[] waterDuration = { 1, 2, 3 };
        System.out.println(sol.earliestFinishTime(landStartTime, landDuration, waterStartTime,
                waterDuration)); // Output: 6
    }
}
