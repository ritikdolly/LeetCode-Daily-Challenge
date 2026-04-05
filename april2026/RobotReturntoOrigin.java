// Date: 05-04-2026
// 657. Robot Return to Origin
// https://leetcode.com/problems/robot-return-to-origin/?envType=daily-question&envId=2026-04-05
public class RobotReturntoOrigin {
    class Solution {
        public boolean judgeCircle(String moves) {
            int x = 0, y = 0;

            for (char move : moves.toCharArray()) {
                if (move == 'U') {
                    y++;
                } else if (move == 'D') {
                    y--;
                } else if (move == 'L') {
                    x--;
                } else if (move == 'R') {
                    x++;
                }
            }

            return x == 0 && y == 0;
        }
    }
    public static void main(String[] args) {
        RobotReturntoOrigin robot = new RobotReturntoOrigin();
        Solution solution = robot.new Solution();

        String moves1 = "UD";
        System.out.println(solution.judgeCircle(moves1)); // Output: true

        String moves2 = "LL";
        System.out.println(solution.judgeCircle(moves2)); // Output: false
    }
}
