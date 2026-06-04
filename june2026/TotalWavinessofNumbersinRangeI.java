// Date: 06-06-2026
// 3751. Total Waviness of Numbers in Range I
// https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/?envType=daily-question&envId=2026-06-04

public class TotalWavinessofNumbersinRangeI {
    class Solution {
        public int totalWaviness(int num1, int num2) {
            int ans = 0;

            for (int i = num1; i <= num2; i++) {
                ans += getWaveCount(i);
            }
            return ans;
        }

        static int getWaveCount(int num) {
            int count = 0;
            String str = Integer.toString(num);
            char[] arr = str.toCharArray();

            for (int i = 1; i < arr.length - 1; i++) {
                if ((arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) || (arr[i] < arr[i - 1] && arr[i] < arr[i + 1])) {
                    count++;
                }
            }
            return count;
        }
    }
    public static void main(String[] args) {
        Solution sol = new TotalWavinessofNumbersinRangeI().new Solution();
        int num1 = 1, num2 = 100;
        System.out.println(sol.totalWaviness(num1, num2)); // Output: 109
    }
}
