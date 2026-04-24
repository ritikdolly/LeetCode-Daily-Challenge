// Date: 24-04-2026
// 2833. Furthest Point From Origin
// https://leetcode.com/problems/furthest-point-from-origin/description/?envType=daily-question&envId=2026-04-24

public class FurthestPointFromOrigin {
    class Solution {
        public int furthestDistanceFromOrigin(String moves) {
            int left = 0, right = 0, blank = 0;

            for (char ch : moves.toCharArray()) {
                if (ch == 'L')
                    left++;
                else if (ch == 'R')
                    right++;
                else
                    blank++;
            }

            return Math.abs(left - right) + blank;
        }
    }
}
