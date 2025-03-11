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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans;  // curr pointer will traverse through ans list and add answers
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;    // tab list2 ko aatach karo
                list2 = list2.next;  // list used as pointer to traverse
            }
            curr = curr.next;     //curr ko update kardo for next cycle
        }
        if(list1 != null) curr.next = list1;  // baccha list1 agar

        if(list2 != null) curr.next = list2;  // bachha list2 join kardo
                
        return ans.next;
    }
}