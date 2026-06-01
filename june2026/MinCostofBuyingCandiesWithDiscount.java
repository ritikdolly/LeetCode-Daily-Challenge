// Date:01-06-2026
// 2144. Minimum Cost of Buying Candies With Discount
// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/?envType=daily-question&envId=2026-06-01

import java.util.Arrays;

public class MinCostofBuyingCandiesWithDiscount {
    class Solution {
        public int minimumCost(int[] cost) {
            int n = cost.length;
            Arrays.sort(cost);
            int ans = 0;
            int taken = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (taken == 2) {
                    taken = 0;
                } else {
                    ans += cost[i];
                    taken++;
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution sol = new MinCostofBuyingCandiesWithDiscount().new Solution();
        int[] cost = {1, 2, 3};
        System.out.println(sol.minimumCost(cost)); // Output: 5
    }
}
