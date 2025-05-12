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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr != null){
            if(curr.next != null && curr.next.val == curr.val){
                while( curr.next != null && curr.next.val == curr.val) curr = curr.next;
                prev.next= curr.next;
                curr = curr.next;
            }
            else{
            prev = curr; 
            curr = curr.next;
            }
            
        }
        return dummy.next;
    }
}