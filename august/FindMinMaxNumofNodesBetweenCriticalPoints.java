// Date: 31-08-2026
// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/?envType=daily-question&envId=2026-08-31

import java.util.ArrayList;
import java.util.List;

public class FindMinMaxNumofNodesBetweenCriticalPoints {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // approach 1: O(n) time and O(n) space
    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return new int[] { -1, -1 };
            }

            ListNode prev = head;
            ListNode temp = head.next;
            ListNode next = head.next.next;

            List<Integer> arr = new ArrayList<>();
            int pos = 2;

            while (next != null) {
                // Local maximum
                if (temp.val > prev.val && temp.val > next.val) {
                    arr.add(pos);
                }

                // Local minimum
                if (temp.val < prev.val && temp.val < next.val) {
                    arr.add(pos);
                }

                prev = temp;
                temp = next;
                next = next.next;
                pos++;
            }

            if (arr.size() < 2) {
                return new int[] { -1, -1 };
            }

            int min = Integer.MAX_VALUE;

            for (int i = 1; i < arr.size(); i++) {
                min = Math.min(min, arr.get(i) - arr.get(i - 1));
            }

            int max = arr.get(arr.size() - 1) - arr.get(0);

            return new int[] { min, max };
        }
    }
    

    // Approach 2: O(n) time and O(1) space
    // class Solution {
    //     public int[] nodesBetweenCriticalPoints(ListNode head) {
    //         int[] ans = new int[2];
    //         int idx = 1;
    //         int f_idx = -1;
    //         int l_idx = -1;
    //         int min_dist = Integer.MAX_VALUE;

    //         ListNode a = head;
    //         ListNode b = a.next;
    //         ListNode c = b.next;
    //         if (c == null) { // 2 nodes only
    //             ans[0] = -1;
    //             ans[1] = -1;
    //             return ans;
    //         }

    //         while (c != null) {
    //             if (b.val < a.val && b.val < c.val || b.val > a.val && b.val > c.val) {
    //                 if (f_idx == -1)
    //                     f_idx = idx;
    //                 if (l_idx != -1) {
    //                     int dist = idx - l_idx;
    //                     min_dist = Math.min(dist, min_dist);
    //                 }
    //                 l_idx = idx;
    //             }

    //             idx++;
    //             a = a.next;
    //             b = b.next;
    //             c = c.next;

    //         }

    //         int max_dist = l_idx - f_idx;
    //         if (max_dist == 0)
    //             max_dist = -1;

    //         if (min_dist == Integer.MAX_VALUE)
    //             min_dist = -1;

    //         ans[0] = min_dist;
    //         ans[1] = max_dist;

    //         return ans;

    //     }
    // }

    public static void main(String[] args) {
        FindMinMaxNumofNodesBetweenCriticalPoints obj = new FindMinMaxNumofNodesBetweenCriticalPoints();
        Solution solution = obj.new Solution();

        // Create a linked list: 1 -> 3 -> 2 -> 4 -> 5
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(3);
        head.next.next = obj.new ListNode(2);
        head.next.next.next = obj.new ListNode(4);
        head.next.next.next.next = obj.new ListNode(5);

        int[] result = solution.nodesBetweenCriticalPoints(head);
        System.out.println("Minimum nodes between critical points: " + result[0]);
        System.out.println("Maximum nodes between critical points: " + result[1]);
    }
}
