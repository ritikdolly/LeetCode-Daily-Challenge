// Date: 02-06-2026
// 3633. Earliest Finish Time for Land and Water Rides I
// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/description/?envType=daily-question&envId=2026-06-02
public class EarliestFinishTimeforLandandWaterRidesI {
    class Solution {
        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime,
                int[] waterDuration) {

            int landFinishTime = Integer.MAX_VALUE;
            int waterFinishTime = Integer.MAX_VALUE;

            int ans = Integer.MAX_VALUE;
            // for land
            for (int i = 0; i < landDuration.length; i++) {
                landFinishTime = Math.min(landFinishTime, landStartTime[i] + landDuration[i]);
            }

            for (int i = 0; i < waterDuration.length; i++) {
                int curr = Math.max(landFinishTime, waterStartTime[i]) + waterDuration[i];
                ans = Math.min(ans, curr);
            }

            // for water
            for (int i = 0; i < waterDuration.length; i++) {
                waterFinishTime = Math.min(waterFinishTime, waterStartTime[i] + waterDuration[i]);
            }

            for (int i = 0; i < landDuration.length; i++) {
                int curr = Math.max(waterFinishTime, landStartTime[i]) + landDuration[i];
                ans = Math.min(ans, curr);
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution sol = new EarliestFinishTimeforLandandWaterRidesI().new Solution();
        int[] landStartTime = { 1, 2, 3 };
        int[] landDuration = { 3, 2, 1 };
        int[] waterStartTime = { 2, 3, 4 };
        int[] waterDuration = { 1, 2, 3 };
        System.out.println(sol.earliestFinishTime(landStartTime, landDuration, waterStartTime,
                waterDuration)); // Output: 6
    }
}
