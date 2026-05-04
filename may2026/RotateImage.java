// Date  : 04-05-2026
// 48. Rotate Image
// https://leetcode.com/problems/rotate-image/description/?envType=daily-question&envId=2026-05-04

public class RotateImage {

    class Solution {
        public void rotate(int[][] mat) {
            int n = mat.length, k = n - 1;
            for (int i = 0; i < n >> 1; i++)
                for (int j = i; j < k - i; j++) {
                    int t = mat[i][j];
                    mat[i][j] = mat[k - j][i];
                    mat[k - j][i] = mat[k - i][k - j];
                    mat[k - i][k - j] = mat[j][k - i];
                    mat[j][k - i] = t;
                }
        }
    }
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        solution.rotate(mat1);
        for (int[] row : mat1) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}