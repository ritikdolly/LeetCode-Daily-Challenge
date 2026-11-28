// DAte: 28-11-2026
// 3947. Maximum Number of Items From Sale II
// https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/description/?envType=daily-question&envId=2026-11-28
import java.util.Arrays;
public class MaxNoofItemsFromSaleII {

    

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Find maximum factor
        int maxFactor = 0;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
        }

        // Step 2: Frequency array
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 3: Calculate free item gain
        int[] gain = new int[maxFactor + 1];

        for (int f = 1; f <= maxFactor; f++) {

            int count = 0;

            for (int j = f; j <= maxFactor; j += f) {
                count += freq[j];
            }

            gain[f] = count - 1;
        }

        // Step 4: Sort items by price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int minPrice = items[0][1];

        long remaining = budget;
        long answer = 0;

        // Step 5: Purchase items with free-item benefits
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // No benefit compared with buying
            // the cheapest item normally
            if (price >= 2L * minPrice) {
                break;
            }

            // Maximum useful copies
            long count = Math.min(
                gain[factor],
                remaining / price
            );

            // Each purchase gives 2 items
            answer += count * 2;

            remaining -= count * price;
        }

        // Step 6: Purchase cheapest items
        // with the remaining budget
        answer += remaining / minPrice;

        return (int) answer;
    }
}

}