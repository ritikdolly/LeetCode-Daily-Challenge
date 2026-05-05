// date:05-05-2026
// 61. Rotate List  
// https://leetcode.com/problems/rotate-list/description/?envType=daily-question&envId=2026-05-05

public class RotateList {
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            ListNode curr = head;
            int len = 1;
            while (curr.next != null) {
                curr = curr.next;
                len++;
            }
            curr.next = head;

            k %= len;
            int steptohead = len - k;
            ListNode newtail = head;
            for (int i = 1; i < steptohead; i++) {
                newtail = newtail.next;
            }
            ListNode newhead = newtail.next;
            newtail.next = null;
            return newhead;
        }
    }
    
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        Solution solution = rotateList.new Solution();

        ListNode head1 = rotateList.new ListNode(1);
        head1.next = rotateList.new ListNode(2);
        head1.next.next = rotateList.new ListNode(3);
        head1.next.next.next = rotateList.new ListNode(4);
        head1.next.next.next.next = rotateList.new ListNode(5);

        int k1 = 2;
        ListNode result1 = solution.rotateRight(head1, k1);
        printList(result1); // Expected Output: 4 -> 5 -> 1 -> 2 -> 3

        ListNode head2 = rotateList.new ListNode(0);
        head2.next = rotateList.new ListNode(1);
        head2.next.next = rotateList.new ListNode(2);

        int k2 = 4;
        ListNode result2 = solution.rotateRight(head2, k2);
        printList(result2); // Expected Output: 2 -> 0 -> 1
    }
}
