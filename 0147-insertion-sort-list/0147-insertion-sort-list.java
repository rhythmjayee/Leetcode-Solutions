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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dumy = new ListNode();
        //node after that we need to replace the smaller node
        ListNode prev = dumy;
        //node before that we need to replace the smaller node
        ListNode tmp = head;
        //node to be replaced
        ListNode node = head.next;
        ListNode nodePrev = head;
        
        dumy.next = head;
        //prev tmp nodePrev node nxt
        while(node != null) {
            ListNode nxt = node.next;
            while(tmp.val < node.val) {
                prev = tmp;
                tmp = tmp.next;
            }
            //Join node in its correct position
            prev.next = node;
            //handle case if node already in its correct position
            node.next = tmp == node ? nxt : tmp;
            nodePrev.next = tmp == node ? node : nxt;
            nodePrev = tmp == node ? node : nodePrev;
            //move to next node to find its correct position
            node = nxt;
            //reset searching nodes
            tmp = dumy.next;
            prev = dumy;
        }
        return dumy.next;
    }
}