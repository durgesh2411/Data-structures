/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        else if(node.next == null) {
            System.out.println("node is the las element here!!");
            return;
        }
  
        node.val = node.next.val;
        node.next = node.next.next;
    }
}