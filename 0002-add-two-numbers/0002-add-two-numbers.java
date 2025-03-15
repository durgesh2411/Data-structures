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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //  since given non null ll so no edge cases:
        ListNode result = new ListNode(0);
        ListNode temp = result; 
        int carry = 0;
        while(l1!=null || l2!=null || carry != 0){    // loop runs till l1 is left,l2 is left,or only carry is left.
        int sum = 0;
        if(l1!=null){
            sum+=l1.val;
            l1 = l1.next;
        }
        if((l2!=null)){
            sum+=l2.val;
            l2 = l2.next;
        }
        sum+=carry;
        carry = sum/10;
        ListNode newNode = new ListNode(sum%10);
        temp.next = newNode;
        temp = temp.next;
        }
        return result.next;
    }
}