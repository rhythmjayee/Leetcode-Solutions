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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode first = head;
        ListNode second = head;
        ListNode prev = dumy;
        
        while(n-- > 0) {
            second = second.next;
        }
        while(second != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }
        if(prev != null) prev.next = first.next;
        return dumy.next;
    }
}