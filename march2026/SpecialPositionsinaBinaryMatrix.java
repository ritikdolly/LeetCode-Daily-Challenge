// Date : 04-03-2026
// 1582. Special Positions in a Binary Matrix
// https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/?envType=daily-question&envId=2026-04-03
public class SpecialPositionsinaBinaryMatrix {
    class Solution {
        public int numSpecial(int[][] mat) {
            int m = mat.length; // Number of rows
            int n = mat[0].length; // Number of columns

            int[] rowSum = new int[m];
            int[] colSum = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rowSum[i] += mat[i][j];
                    colSum[j] += mat[i][j];
                }
            }

            int specialPosition = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1)
                        specialPosition++;
                }
            }
            return specialPosition;
        }
}
    public static void main(String[] args) {
        Solution solution = new SpecialPositionsinaBinaryMatrix().new Solution();
        int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        int result = solution.numSpecial(mat);
        System.out.println(result); // Output: 1
    }
}
