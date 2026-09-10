// Date: 10-09-2026
// problem title: 2265. Count Nodes Equal to Average of Subtree
// problem link:https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/?envType=daily-question&envId=2026-09-10

public class CountNodesEqualtoAverageofSubtree {
    public class TreeNode {
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
        int ans = 0;

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int[] dfs(TreeNode node) {
            if (node == null)
                return new int[] { 0, 0 };
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            int sum = left[0] + right[0] + node.val;
            int cnt = left[1] + right[1] + 1;
            if (sum / cnt == node.val)
                ans++;
            return new int[] { sum, cnt };
        }
    }

    public static void main(String[] args) {
        CountNodesEqualtoAverageofSubtree solution = new CountNodesEqualtoAverageofSubtree();
        Solution averageOfSubtreeSolution = solution.new Solution();

        // Test cases
        TreeNode root1 = solution.new TreeNode(1);
        root1.left = solution.new TreeNode(2);
        root1.right = solution.new TreeNode(3);
        System.out.println(averageOfSubtreeSolution.averageOfSubtree(root1)); // Output: 2

        TreeNode root2 = solution.new TreeNode(4);
        root2.left = solution.new TreeNode(8);
        root2.right = solution.new TreeNode(5);
        root2.left.left = solution.new TreeNode(0);
        root2.left.right = solution.new TreeNode(1);
        System.out.println(averageOfSubtreeSolution.averageOfSubtree(root2)); // Output: 5
    }
}
