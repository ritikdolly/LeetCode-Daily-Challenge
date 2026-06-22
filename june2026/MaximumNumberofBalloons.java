// Date: 22-06-2026
// 1189. Maximum Number of Balloons
// https://leetcode.com/problems/maximum-number-of-balloons/description/?envType=daily-question&envId=2026-06-22
public class MaximumNumberofBalloons {
    class Solution {
        public int maxNumberOfBalloons(String text) {
            char[] arr = text.toCharArray();
            int ans = 0;

            while (true) {
                String word = "balloon";

                for (char c : word.toCharArray()) {
                    boolean found = false;

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == c) {
                            arr[i] = '#';
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        return ans;
                }

                ans++;
            }
        }
    }
    public static void main(String[] args) {
        MaximumNumberofBalloons maxBalloons = new MaximumNumberofBalloons();
        Solution solution = maxBalloons.new Solution();

        String text = "nlaebolko";
        int result = solution.maxNumberOfBalloons(text);
        System.out.println(result); // Output: 1
    }
}
