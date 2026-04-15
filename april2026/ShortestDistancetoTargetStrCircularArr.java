// Date: 15-04-2026
// 2515. Shortest Distance to Target String in a Circular Array
// https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/?envType=daily-question&envId=2026-04-15

public class ShortestDistancetoTargetStrCircularArr {

    class Solution {
        public int closestTarget(String[] words, String target, int start) {
            int n = words.length;
            for (int i = 0; i <= n >> 1; i++)
                if (words[(start + i) % n].equals(target) |
                        words[(start - i + n) % n].equals(target))
                    return i;

            return -1;
        }
}
    public static void main(String[] args) {
        ShortestDistancetoTargetStrCircularArr sol = new ShortestDistancetoTargetStrCircularArr();
        Solution solution = sol.new Solution();

        String[] words1 = {"hello", "i", "am", "leetcode"};
        String target1 = "hello";
        int start1 = 1;
        System.out.println(solution.closestTarget(words1, target1, start1)); // Output: 1

        String[] words2 = {"a", "b", "leetcode"};
        String target2 = "leetcode";
        int start2 = 0;
        System.out.println(solution.closestTarget(words2, target2, start2)); // Output: 2

        String[] words3 = {"i", "eat", "leetcode"};
        String target3 = "ate";
        int start3 = 0;
        System.out.println(solution.closestTarget(words3, target3, start3)); // Output: -1
    }
}