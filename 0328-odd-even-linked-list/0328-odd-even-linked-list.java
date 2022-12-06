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
        if(head == null || head.next == null) return head;
        
        ListNode odd = new ListNode(-1);
        ListNode od = odd;
        ListNode even = new ListNode(-1);
        ListNode ev = even;
        int count = 1;
        
        while(head != null){
            ListNode next = head.next;
            if(count % 2 == 0){
                ev.next = head;
                ev = head;
            }else{
                od.next = head;
                od = head;
            }  
            head = next;
            od.next = null;
            ev.next = null;
            count++;
        }
        
        od.next = even.next;
        return odd.next;
    }
}