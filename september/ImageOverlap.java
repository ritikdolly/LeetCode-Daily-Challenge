// Date: 13-09-2026
// Problem title: 835. Image Overlap
// problem link: https://leetcode.com/problems/image-overlap/description/?envType=daily-question&envId=2026-09-13

public class ImageOverlap {

    // Approach: using by checking all possible translations of img2 over img1 and counting the number of overlapping 1s.
    class Solution {
        public int largestOverlap(int[][] img1, int[][] img2) {
            int ans = 0;
            int n = img1.length;

            for (int down = -(n - 1); down < n; down++) {
                for (int right = -(n - 1); right < n; right++) {
                    int count = 0;

                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {

                            if (img2[row][col] == 1) {
                                int newRow = row + down;
                                int newCol = col + right;

                                if (newRow >= 0 && newCol < n &&
                                        newCol >= 0 && newRow < n &&
                                        img1[newRow][newCol] == 1) {
                                    count++;
                                }
                            }
                        }
                    }
                    ans = Math.max(ans, count);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ImageOverlap().new Solution();
        int[][] img1 = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
        int[][] img2 = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
        System.out.println(solution.largestOverlap(img1, img2)); // Output: 3
    }

}
