// Date:18-06-2026
// problem: 1344. Angle Between Hands of a Clock
// https://leetcode.com/problems/angle-between-hands-of-a-clock/description/?envType=daily-question&envId=2026-06-18
public class AngleBetweenHandsofClock {

    // Approach: Calculate the angles of the hour and minute hands separately, then find the absolute difference between them. Finally, return the smaller angle between the two possible angles (the direct angle and the reflex angle). 
    class Solution {
        public double angleClock(int hour, int minutes) {
            double minuteAngle = 6.0 * minutes;
            double hourAngle = 30.0 * (hour % 12) + 0.5 * minutes;

            double diff = Math.abs(hourAngle - minuteAngle);

            return Math.min(diff, 360.0 - diff);
        }
    }
    public static void main(String[] args) {
        AngleBetweenHandsofClock obj = new AngleBetweenHandsofClock();
        Solution solution = obj.new Solution();

        int hour = 3;
        int minutes = 15;
        double result = solution.angleClock(hour, minutes);
        System.out.println(result); // Output: 7.5
    }
}