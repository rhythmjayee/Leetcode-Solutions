class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        else if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverseList(slow.next);

        while (rev != null && head != null) {
            if (rev.val != head.val) return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = null; // prev of p

        while (head != null) {
            ListNode next = head.next; //represent the next of p
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }

}