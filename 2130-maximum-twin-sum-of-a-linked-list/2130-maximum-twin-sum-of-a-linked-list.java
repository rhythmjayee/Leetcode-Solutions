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
    public int pairSum(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        ListNode prev = head;
        
        while(f != null && f.next != null) {
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = null;
        ListNode head2 = rev(s);
        
        int max = 0;
        while(head != null && head2 != null) {
            int v = head.val + head2.val;
            max = Math.max(max, v);
            head = head.next;
            head2 = head2.next;
        }
        return max;
    }
    public ListNode rev(ListNode head) {
        ListNode t = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = t;
            t = head;
            head = next;
        }
        return t;
    }
}