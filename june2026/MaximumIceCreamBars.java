// Date: 21-06-2026
// problem: 1833. Maximum Ice Cream Bars
// https://leetcode.com/problems/maximum-ice-cream-bars/description/?envType=daily-question&envId=2026-06-21

import java.util.Arrays;

class MaximumIceCreamBars {
    // Approach 1: Sorting
    // class Solution {
    //     public int maxIceCream(int[] costs, int coins) {
    //         Arrays.sort(costs);

    //         int count = 0;

    //         for (int cost : costs) {
    //             if (coins >= cost) {
    //                 coins -= cost;
    //                 count++;
    //             } else {
    //                 break;
    //             }
    //         }

    //         return count;
    //     }
    // }

    // Approach 2: Using Frequency Array
    class Solution {
        public int maxIceCream(int[] costs, int coins) {

            final int MAX_COST = 100000;

            int[] freq = new int[MAX_COST + 1];

            for (int cost : costs) {
                freq[cost]++;
            }

            int answer = 0;

            for (int cost = 1; cost <= MAX_COST; cost++) {

                if (freq[cost] == 0) {
                    continue;
                }

                int canBuy = Math.min(freq[cost], coins / cost);

                answer += canBuy;

                coins -= canBuy * cost;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        MaximumIceCreamBars maxIceCreamBars = new MaximumIceCreamBars();
        Solution solution = maxIceCreamBars.new Solution();

        int[] costs = { 1, 3, 2, 4, 1 };
        int coins = 7;

        int result = solution.maxIceCream(costs, coins);
        System.out.println("Maximum ice cream bars that can be bought: " + result);
    }
}