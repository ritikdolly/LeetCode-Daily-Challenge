// Date: 24-02-2026
// 1022. Sum of Root To Leaf Binary Numbers
// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/?envType=daily-question&envId=2026-02-24


public class SumofRootToLeafBinaryNumbers {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        private int dfs(TreeNode root, int currSum) {
            if (root == null) {
                return 0;
            }
            currSum = currSum * 2 + root.val;

            if (root.left == null && root.right == null) {
                return currSum;
            }

            return dfs(root.left, currSum) + dfs(root.right, currSum);
        }

        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }
    }
    public static void main(String[] args) {
        Solution solution = new SumofRootToLeafBinaryNumbers().new Solution();
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        int result = solution.sumRootToLeaf(root);
        System.out.println(result); // Output: 22
    }

}
