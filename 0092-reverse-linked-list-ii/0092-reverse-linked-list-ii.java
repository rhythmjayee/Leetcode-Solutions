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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        
        ListNode d = new ListNode(0);
        d.next = head;
        head = d;
        
        ListNode prev = d;
        ListNode next = null;
        int count = 0;
        ListNode rv = null;
        
        while(head != null && count <= right) {
            ListNode nx = head.next;
            if(count == left - 1) {
                prev = head;
                rv = head.next;
            }
            if(count == right) {
                head.next = null;
            }
            head = nx;
            count++;
        }
        ListNode newRvH = reverseList(rv);
        prev.next = newRvH;
        rv.next = head;
        
        return d.next;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}