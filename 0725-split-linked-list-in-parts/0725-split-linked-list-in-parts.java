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
    public int _len(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = _len(head);
        int r = len % k;
        int sz = len / k;//min len to build for single LL
        int idx = 0;
        ListNode[] ans = new ListNode[k];
        
        while(head != null) {
            int count = sz + (r-- > 0 ? 1 : 0);
            ListNode temp = head;
            ListNode prev = head;
            while(count-- > 0 && temp != null) {
                prev = temp;
                temp = temp.next;
            }
            ans[idx++] = head;
            head = temp;
            prev.next = null;
        }
        return ans;
    }
}