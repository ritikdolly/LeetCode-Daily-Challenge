// Date: 15-06-2026
// 2095. Delete the Middle Node of a Linked List
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=daily-question&envId=2026-06-15

public class DeletetheMiddleNodeofaLinkedList {

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
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode slow = head, fast = head, prev = null;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;

                prev = slow;
                slow = slow.next;
            }

            prev.next = slow.next;

            return head;
        }
    }
    public static void main(String[] args) {
        DeletetheMiddleNodeofaLinkedList solution = new DeletetheMiddleNodeofaLinkedList();
        Solution sol = solution.new Solution();

        // Example usage:
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(3);
        head.next.next = solution.new ListNode(4);
        head.next.next.next = solution.new ListNode(7);
        head.next.next.next.next = solution.new ListNode(1);
        head.next.next.next.next.next = solution.new ListNode(2);
        head.next.next.next.next.next.next = solution.new ListNode(6);

        ListNode result = sol.deleteMiddle(head);

        // Print the resulting linked list
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}