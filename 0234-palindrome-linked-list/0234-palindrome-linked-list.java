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
        public ListNode reverse(ListNode temp){
        ListNode prev = null;
        while(temp != null){
            ListNode after =  temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // System.out.println(slow.val);
        // System.out.println(fast.val);
        ListNode mid = slow;
        ListNode second = reverse(mid);
        ListNode first = head;
        while(second != null){
            if(second.val != first.val) return false;
            second = second.next;
            first = first.next;
        }
        return true;
}
}