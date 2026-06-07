// Date: 07-06-2026
// 2196. Create Binary Tree From Descriptions
// https://leetcode.com/problems/create-binary-tree-from-descriptions/?envType=daily-question&envId=2026-06-07

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {

    // Definition for a binary tree node.
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

    // Approach: Using a HashMap to store nodes and a HashSet to track children
    class Solution {

        public TreeNode createBinaryTree(int[][] descriptions) {
            Set<Integer> children = new HashSet<>();
            Map<Integer, TreeNode> map = new HashMap<>();

            for (int[] node : descriptions) {
                int parent = node[0];
                int child = node[1];
                int isLeft = node[2];

                children.add(child);

                TreeNode parentNode = map.computeIfAbsent(parent, TreeNode::new);
                TreeNode childNode = map.computeIfAbsent(child, TreeNode::new);

                if (isLeft == 1) {
                    parentNode.left = childNode;
                } else {
                    parentNode.right = childNode;
                }
            }

            for (int[] node : descriptions) {
                if (!children.contains(node[0])) {
                    return map.get(node[0]);
                }
            }

            return null;
        }
    }


    public static void main(String[] args) {
        Solution sol = new CreateBinaryTreeFromDescriptions().new Solution();
        int[][] descriptions = { { 1, 2, 1 }, { 1, 3, 0 }, { 2, 4, 1 } };
        TreeNode root = sol.createBinaryTree(descriptions);
        // The tree structure will be:
        // 1
        // / \
        // 2 3
        // /
        // 4
    }
}
