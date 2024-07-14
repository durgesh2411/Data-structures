/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
            HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        // Dummy head to handle edge cases where head node itself needs to be removed
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // Pointers for traversal
        ListNode prev = dummyHead;
        ListNode curr = head;

        // Traverse the linked list
        while (curr != null) {
            if (numsSet.contains(curr.val)) {
                // Remove current node by adjusting pointers
                prev.next = curr.next;
            } else {
                // Move prev pointer forward
                prev = curr;
            }
            // Move curr pointer forward
            curr = curr.next;
        }

        // Return the modified linked list
        return dummyHead.next;
    }

    // Utility function to create a linked list from an array of integers
    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Utility function to print a linked list
    public void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}