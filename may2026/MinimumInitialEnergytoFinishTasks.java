// Date:12-05-2026
// 1665. Minimum Initial Energy to Finish Tasks
// https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/description/?envType=daily-question&envId=2026-05-12

import java.util.Arrays;

public class MinimumInitialEnergytoFinishTasks {
    class Solution {
        public int minimumEffort(int[][] shop) {
            Arrays.sort(shop, (a, b) -> b[1] - b[0] - (a[1] - a[0]));

            int start = shop[0][1];
            int bal = shop[0][1] - shop[0][0];
            int loan = 0;

            for (int i = 1; i < shop.length; i++) {
                int cost = shop[i][0];
                int thresh = shop[i][1];

                if (bal < thresh) {
                    loan += thresh - bal;
                    bal = thresh;
                }

                bal -= cost;
            }

            return start + loan;
        }
    }
    public static void main(String[] args) {
        MinimumInitialEnergytoFinishTasks m = new MinimumInitialEnergytoFinishTasks();
        Solution s = m.new Solution();

        int[][] shop = {{1, 2}, {2, 4}, {4, 8}};

        System.out.println(s.minimumEffort(shop));
    }
}
