// Date: 14-06-2026
// 2130. Maximum Twin Sum of a Linked List
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=daily-question&envId=2026-06-14

public class MaximumTwinSumofaLinkedList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public int pairSum(ListNode head) {
            ListNode slow = head, fast = head, prev = null;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;

                ListNode nxt = slow.next;
                slow.next = prev;
                prev = slow;
                slow = nxt;
            }

            int ans = 0;
            ListNode left = prev, right = slow;

            while (left != null) {
                ans = Math.max(ans, left.val + right.val);
                left = left.next;
                right = right.next;
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        MaximumTwinSumofaLinkedList solution = new MaximumTwinSumofaLinkedList();
        Solution sol = solution.new Solution();

        // Example usage:
        ListNode head = solution.new ListNode(5);
        head.next = solution.new ListNode(4);
        head.next.next = solution.new ListNode(2);
        head.next.next.next = solution.new ListNode(1);

        int result = sol.pairSum(head);
        System.out.println("Maximum Twin Sum: " + result); // Output: 6
    }
    
}