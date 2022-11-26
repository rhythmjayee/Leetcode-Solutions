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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode f = head;
        ListNode s = head;
        
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode head2 = s.next;
        s.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        
        return merge(l1, l2);
    }
    public ListNode merge(ListNode h1, ListNode h2) {
        if(h1 == null) return h2;
        else if(h2 == null) return h1;
        
        ListNode d = new ListNode();
        ListNode tmp = d;
        while(h1 != null || h2 != null) {
            int v1 = h1 == null ? Integer.MAX_VALUE : h1.val;
            int v2 = h2 == null ? Integer.MAX_VALUE : h2.val;
            if(v1 <= v2) {
                tmp.next = h1;
                h1 = h1.next;
            }else {
                tmp.next = h2;
                h2 = h2.next;
            }
            tmp = tmp.next;
        }
        return d.next;
    }
}