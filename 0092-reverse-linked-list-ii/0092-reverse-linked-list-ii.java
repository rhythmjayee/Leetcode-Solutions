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
        //LL_front -> LL_rev -> LL_back
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int idx = 1;
        while(head != null) {
            ListNode tmp = head;
            if(idx == left) {
                while(tmp != null && idx != right) {
                    tmp = tmp.next;
                    idx++;
                }
                //pointer to LL_back
                ListNode nxt = tmp.next;
                tmp.next = null;
                ListNode rv = reverseList(head);//LL_rev
                //connect LL_front -> LL_rev
                prev.next = rv;
                //connect LL_rev -> LL_back
                head.next = nxt;
                break;
            } else {
                //prev will be iterating over the LL_front
                prev.next = head;
                prev = head;
                head = head.next;
                idx++;
            }
        }
        
        return dummy.next;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}