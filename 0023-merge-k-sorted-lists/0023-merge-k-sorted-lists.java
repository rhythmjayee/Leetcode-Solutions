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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode dumy = new ListNode();
        ListNode tmp = dumy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode l : lists) {
            if(l != null)
                pq.add(l);
        }
        
        while(!pq.isEmpty()) {
            ListNode rm = pq.poll();
            tmp.next = rm;
            tmp = rm;
            if(rm.next != null) pq.add(rm.next);
        }
        return dumy.next;
    }
}