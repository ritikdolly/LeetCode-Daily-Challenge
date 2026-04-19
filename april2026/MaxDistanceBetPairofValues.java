// Date: 19-04-2026
// 1855. Maximum Distance Between a Pair of Values
// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/?envType=daily-question&envId=2026-04-19
public class MaxDistanceBetPairofValues {
    class Solution {
    public int maxDistance(int[] A, int[] B) {
        int i, j = 1;

        for (i = 0; i < A.length && j < B.length; j++)
            if (A[i] > B[j])
                i++;

        return j - i - 1;
    }
}
    public static void main(String[] args) {
        // write main method code here
        Solution sol = new MaxDistanceBetPairofValues().new Solution();
    	int[] A = {1, 2, 3};
        int[] B = {1, 2, 3};
        System.out.println(sol.maxDistance(A, B));
        
    }
}
