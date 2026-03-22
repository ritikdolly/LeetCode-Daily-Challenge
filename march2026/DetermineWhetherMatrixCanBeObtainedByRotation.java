// Date: 22-03-2026
// 1886. Determine Whether Matrix Can Be Obtained By Rotation
// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/?envType=daily-question&envId=2026-03-22

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            for (int k = 0; k < 4; k++) {
                if (areEqual(mat, target)) {
                    return true;
                }
                mat = rotate(mat);
            }
            return false;
        }

        private boolean areEqual(int[][] a, int[][] b) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] != b[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        private int[][] rotate(int[][] mat) {
            int n = mat.length;
            int[][] rotated = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rotated[i][j] = mat[n - j - 1][i];
                }
            }
            return rotated;
        }
    }

    public static void main(String[] args) {
        Solution solution = new DetermineWhetherMatrixCanBeObtainedByRotation().new Solution();
        int[][] mat = {{0, 1}, {1, 0}};
        int[][] target = {{1, 0}, {0, 1}};
        System.out.println(solution.findRotation(mat, target)); // Output: true
    }
}
