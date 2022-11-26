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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode slowNext = slow.next;//mid node
        slow.next = null;
        
        ListNode otherHead = revList(slowNext);
        connectLists(head,otherHead);
    }
    public ListNode connectLists(ListNode l1, ListNode l2){
        ListNode Dummy = new ListNode();
        ListNode temp = Dummy;
        
        while(l1 != null || l2 != null){
            ListNode l1Next = l1.next;
            temp.next = l1;
            l1.next = l2 == null ? null : l2;
            temp = l2 == null ? l1 : l2;
            l1 = l1Next;
            l2 = l2 == null? null : l2.next;
            
        }
        
        return Dummy.next;
    }
    public ListNode revList(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode newHead = revList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}