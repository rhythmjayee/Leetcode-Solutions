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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode d = new ListNode(0);
        ListNode t = d;
        
        while(head != null && head.next != null) {
            ListNode next = head.next.next;
            ListNode a = head;
            ListNode b = head.next;
            
            b.next = a;
            a.next = null;
            t.next = b;
            t = a;
            
            head = next;
        }
        if(head != null) t.next = head;
        
        return d.next;
    }
}