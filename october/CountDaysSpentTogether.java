// date: 24--10-2026
// problem titles: 2409. Count Days Spent Together
// problem link: https://leetcode.com/problems/count-days-spent-together/description/?envType=daily-question&envId=2026-10-24
public class CountDaysSpentTogether {


    // Approach: Convert the dates into day numbers of the year and find the overlapping days.
    class Solution {
        static int[] months = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        // Convert MM-DD into the day number of the year
        int totalDayStay(String date) {
            int month = Integer.parseInt(date.substring(0, 2));
            int day = Integer.parseInt(date.substring(3, 5));

            int total = day;

            for (int i = 0; i < month - 1; i++) {
                total += months[i];
            }

            return total;
        }

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob,
                String leaveBob) {
            int startAlice = totalDayStay(arriveAlice);
            int endAlice = totalDayStay(leaveAlice);

            int startBob = totalDayStay(arriveBob);
            int endBob = totalDayStay(leaveBob);

            int start = Math.max(startAlice, startBob);
            int end = Math.min(endAlice, endBob);

            return Math.max(0, end - start + 1);
        }
    }

    public static void main(String[] args) {
        CountDaysSpentTogether solution = new CountDaysSpentTogether();
        Solution sol = solution.new Solution();

        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";

        int result = sol.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println("Days spent together: " + result);
    }
}