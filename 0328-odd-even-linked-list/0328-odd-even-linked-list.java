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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddList  = new ListNode();
        ListNode evenList = new ListNode();
        ListNode tailOdd = oddList;
        ListNode tailEven = evenList;
        ListNode temp  = head;
        int cnt = 1;
        while( temp != null){
            if(cnt%2==0){
                ListNode evenNode = new ListNode(temp.val);
                tailEven.next = evenNode;
                tailEven = tailEven.next;
            }
            else{
                ListNode oddNode = new ListNode(temp.val);
                tailOdd.next = oddNode;
                tailOdd = tailOdd.next;
            }
            cnt++;
            temp = temp.next;
        }
        tailOdd.next = evenList.next;
        return oddList.next;
    }
}